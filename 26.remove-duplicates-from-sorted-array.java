/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        // 双指针
        // 时间复杂度O(n)，空间复杂度O(1)
        // i 指向当前需要填充的元素的位置
        // j 指向下一个需要填充的元素的位置
        // 如果当前元素和前一个元素相等，则跳过
        // 如果当前元素和前一个元素不相等，则将当前元素填充到i+1的位置
        // 如果当前元素和前一个元素相等，则将当前元素填充到i+1的位置
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
// @lc code=end

