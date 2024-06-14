/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length <= 1) {
            return nums[0] == target ? 0 : - 1;
        }
        // find the roated point
        
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.printf("\n mid=%d", mid);
            if (nums[mid] == target) {
                return mid;
            }
            
            // if left part is sorted
            if (nums[left] < nums[mid] ){
                if (target < nums[left] || target > nums[mid]) {
                    // target in roated part
                    left = mid + 1;
                } else {
                    right = mid - 1;
                    System.out.printf("\n nums[%d]=%d, left: %d, nums[%d]=%d" , mid, nums[mid], left, left, nums[left]);
                }
                
            } else if (nums[left] > nums[mid] ) {  // [6, 5, 4, 3,  0, 1, 2]
                // right part is rotated
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid  + 1;
                    System.out.printf("\n nums[%d]=%d, left: %d, nums[%d]=%d" , mid, nums[mid], right, right, nums[right]);
                }
        
            } else {
                left++; // for duplicate case: "111111", target = 2
            }
        }

        return -1;

    }
}
// @lc code=end

