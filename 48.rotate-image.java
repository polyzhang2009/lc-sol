/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        // first reverse up row and down row
        int up = 0;
        int down = matrix.length - 1;
        while (up < down) {
            int[] temp = matrix[up];
            matrix[up] = matrix[down];
            matrix[down] = temp;
            up++;
            down--;
        }

        // second swap matrix[i][j] , matrix[j][i]
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int point = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = point;
            }
        }
    }
}
// @lc code=end

