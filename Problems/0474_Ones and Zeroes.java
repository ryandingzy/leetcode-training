class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[n+1][m+1];
        for (String str : strs) {
            int x = 0;
            int y = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    x++;
                } else {
                    y++;
                }
            }
            for (int i = n - x; i >= 0; i--) {
                for (int j = m - y; j >= 0; j--) {
                    dp[i+x][j+y] = Math.max(dp[i+x][j+y], dp[i][j] + 1);
                }
            }
        }
        return dp[n][m];
    }
}
