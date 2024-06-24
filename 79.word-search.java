/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)     
            return false;
        
        char[] target = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (search(board, i, j, 0, target))
                  return true;
            }
        }
        return false;
    }

    public boolean search(char[][] board, int i, int j, int pos, char[]target) {
        if (pos >= target.length) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;

        if (board[i][j] == target[pos]) {
            char c = board[i][j];
            board[i][j] = '#';

            boolean res = search(board, i + 1, j, pos+1, target) ||
            search(board, i, j+1, pos + 1, target) ||
            search(board, i - 1, j, pos + 1, target) ||
            search(board, i, j - 1, pos + 1, target);

            board[i][j] = c;
            return res;
        }
        return false;
    }
}
// @lc code=end

