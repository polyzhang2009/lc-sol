/*
 * @lc app=leetcode id=408 lang=java
 *
 * [408] Valid Word Abbreviation
 */

// @lc code=start
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        // match abbr with word using two pointers
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0') {
                    return false;
                }
                int start = j;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    j++;
                }
                int num = Integer.parseInt(abbr.substring(start, j));
                i += num;
            } else {
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
// @lc code=end

