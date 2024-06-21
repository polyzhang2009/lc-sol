/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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


    public List<List<Integer>> levelOrder(TreeNode root) {
        // BFS - using queue
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) 
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                levelList.add(queue.poll().val);
            }
            res.add(levelList);
        }
        return res;
    }

    // dfs
    public List<List<Integer>> levelOrderDfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        levelHelper(res, root, 0); // height
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;

        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }

        res.get(height).add(root.val);  // 非常巧妙，需要记住！！
        levelHelper(res, root.left, height + 1);
        levelHelper(res, root.right, height + 1);
    }
}
// @lc code=end

