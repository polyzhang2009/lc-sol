/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// import javax.swing.tree.TreeNode;  // 在Leetcode Visua code extension 需要注销这一行

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
//  // 在Leetcode Visua code extension 需要打开TreeNode定义。才能成功提交在线验证。
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    // public List<Integer> preorderTraversal2(TreeNode root) {
    //     List<Integer> res = new LinkedList<>();
    //     if (root == null) {
    //         return res;
    //     }

    //     res.add(root.val);
    //     res.addAll(preorderTraversal(root.left));
    //     res.addAll(preorderTraversal(root.right));
    //     return res;
    // }

    // iterative 
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while ( !stack.isEmpty()) {
            TreeNode p = stack.pop();
            if (p != null) {
                res.add(p.val);
                stack.push(p.right);
                stack.push(p.left);
            }
        }
        return res;
    }



}
// @lc code=end

