/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        if (n == 0) {
            return res;
        }
        recursion(res, "", 0, 0, n);
        return res;
    }

    /*
    The idea here is to only add '(' and ')' that we know will guarantee us a solution (instead of adding 1 too many close). Once we add a '(' we will then discard it and try a ')' which can only close a valid '('. Each of these steps are recursively called.
    */

    private void recursion(List<String> res, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur);
            return;
        }

        if (open < max) {
            recursion(res,  cur + "(", open + 1, close, max);
        } 
        
        if (close < open) {
            recursion(res, cur + ")", open, close + 1, max);
        }
    }
}
// @lc code=end
