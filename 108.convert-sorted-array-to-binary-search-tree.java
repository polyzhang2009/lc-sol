/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // recursive solution
        // find the mid of sorted array
        if (nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }
    

    public TreeNode helper(int[] nums, int begin, int end) {
        if (begin > end) return null;
        int mid = begin + (end - begin) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, begin, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root; // 返回结果不唯一 ： answer: [0,-3,9,-10,null,5] ， [0,-10,5,null,-3,null,9]
    }
}
// @lc code=end

