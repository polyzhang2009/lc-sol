/*
 * @lc app=leetcode id=87 lang=java
 *
 * [87] Scramble String
 */

// @lc code=start
class Solution {
    public boolean isScramble(String s1, String s2) {
        // using dynamic programming, dp[i][j][k] means whether s1[i..i+k-1] is a scramble of s2[j..j+k-1]
        // dp[i][j][k] = dp[i][j][l] && dp[i+l][j+l][k-l] || dp[i][j+k-l][l] && dp[i+l][j][k-l] for all l = 1..k-1
        // dp[i][j][1] = s1[i] == s2[j]
        // dp[i][j][k] = true if s1[i..i+k-1] == s2[j..j+k-1]
        // dp[i][j][k] = false if s1[i..i+k-1] != s2[j..j+k-1]
        // dp[i][j][k] = false if s1[i..i+k-1] is not a scramble of s2[j..j+k-1]
        // dp[i][j][k] = true if s1[i..i+k-1] is a scramble of s2[j..j+k-1]

        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int k = 2; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    for (int l = 1; l < k; l++) {
                        if ((dp[i][j][l] && dp[i + l][j + l][k - l]) || (dp[i][j + k - l][l] && dp[i + l][j][k - l])) {
                            dp[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
// @lc code=end

