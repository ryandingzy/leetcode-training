class Solution {
    public int numDistinct(String s, String t) {
        if (t.length() > s.length()) return 0;
        
        int m = t.length(), n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j < n + 1; j++) dp[0][j] = 1;
        for (int i = 1; i < m + 1; i++) {
            if (t.charAt(i-1) == s.charAt(i-1)) {
                dp[i][i] = dp[i-1][i-1];
            } else {
                dp[i][i] = 0;
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
