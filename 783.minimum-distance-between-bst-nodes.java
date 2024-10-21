/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
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
 
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode prev = null;

    public int minDiffInBST(TreeNode root) {
        // recursive solution
        // 需要一个全局变量来记录前一个节点，然后比较当前节点和前一个节点的差值
        // 需要一个全局变量来记录最小差值，然后比较当前差值和最小差值的差值，取最小值
        if (root == null) {
            return minDiff;
        }
        helper(root);
        return minDiff;
    }

    // inorder traversal
    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prev.val));
        }
        prev = root;
        helper(root.right);
    }
}
// @lc code=end

