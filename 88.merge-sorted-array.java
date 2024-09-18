/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后往前比较，大的放到nums1的最后面
        // 因为nums1的空间足够大，所以可以直接在nums1上操作
        // 如果nums1的空间不够大，可以先拷贝到一个新的数组中，然后再合并
        // 时间复杂度O(m+n)，空间复杂度O(1)
        
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
// @lc code=end

