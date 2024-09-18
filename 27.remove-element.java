/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        // 双指针
        // 时间复杂度O(n)，空间复杂度O(1)
        // i 指向当前需要填充的元素的位置
        // j 指向下一个需要填充的元素的位置
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
// @lc code=end

