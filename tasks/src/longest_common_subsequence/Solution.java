package longest_common_subsequence;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // We only need to use row i and i - 1, so we just need to store two rows.
        int m = text1.length(), n = text2.length();
        if(m < n) return longestCommonSubsequence(text2, text1);
        int[][] dp = new int[2][n + 1];
        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i & 1][j] = dp[(i - 1) & 1][j - 1] + 1;
                } else {
                    dp[i & 1][j] = Math.max(dp[(i - 1) & 1][j], dp[i & 1][j - 1]);
                }
            }
        }
        return dp[m & 1][n];
    }
}