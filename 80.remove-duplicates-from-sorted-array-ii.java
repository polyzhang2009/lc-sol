/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int freq = 2; // 重复次数
        // at most freq times  衍生到freq次
        for (int n: nums) {
            if (i < freq || n > nums[i - freq]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
// @lc code=end

