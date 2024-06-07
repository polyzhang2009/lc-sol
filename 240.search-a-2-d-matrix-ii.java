/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Let say start from the left-top corner, since all other cells are larger than
        // it, we cannot know which direction to search.
        // Solution: start from left-bottom corner or the right-top corner.
        // if larger than target, we move up; otherwise we move right.
        int r = matrix.length - 1;
        int c = 0;

        while (r >= 0 && c < matrix[0].length) {

            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                r--;
            } else {
                c++;
            }
        }
        return false;
    }
}
// @lc code=end
