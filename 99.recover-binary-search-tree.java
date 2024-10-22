/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    // recursive solution
    // inorder traversal
    // 1. 中序遍历，找到两个错误的节点
    // 2. 交换两个错误节点的值
    // 3. 返回
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;


    public void recoverTree(TreeNode root){
        // 中序遍历
        inorder(root);

        // 交换两个错误节点的值
        swap(first, second);
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) first = prev;
            second = root;
        }
        
        prev = root;
        inorder(root.right);   
    }

    private void swap(TreeNode a, TreeNode b) {
        if (a != null && b != null) {
            int tmp = a.val;
            a.val = b.val;
            b.val = tmp;           
        }
    }
    
    // Iterative solution (插件AI生成解法，我没看懂)
    public void recoverTree2(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.left == null) {
                if (prev != null && cur.val < prev.val) {
                    if (first == null) {
                        first = prev;
                    }
                    second = cur;
                }
                prev = cur;
                cur = cur.right;
            } else {
                parent = cur.left;
                while (parent.right != null && parent.right != cur) {
                    parent = parent.right;
                }
                if (parent.right == null) {
                    parent.right = cur;
                    cur = cur.left;
                } else {
                    parent.right = null;
                    if (prev != null && cur.val < prev.val) {
                        if (first == null) {
                            first = prev;
                        }
                        second = cur;
                    }
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
    }
}
// @lc code=end

