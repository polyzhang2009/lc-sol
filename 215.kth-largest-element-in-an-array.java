/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    
    private Random random = new Random();
    
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int targetIndex = nums.length - k; // convert kth largest to (n - k)th smallest
        
        while (left <= right) {
            int pivotIndex = partition(nums, left, right);
            
            if (pivotIndex == targetIndex) {
                return nums[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        return -1;  // This line should theoretically never be reached
    }
    
    private int partition(int[] nums, int left, int right) {
        // Select a random pivot to avoid worst-case time complexity
        int pivotIndex = left + random.nextInt(right - left + 1);
        int pivotValue = nums[pivotIndex];
        
        // Move pivot to the right
        swap(nums, pivotIndex, right);
        int storeIndex = left;
        
        // Partition the array
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }
        
        // Move pivot to its final place
        swap(nums, storeIndex, right);
        return storeIndex;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int findKthLargest2(int[] nums, int k) {
        // use heap to find kth largest element
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2)-> n1 - n2);
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}
// @lc code=end

