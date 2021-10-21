class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        int[] dp = new int[n];
        
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[j][0] < envelopes[i][0] &&
                   envelopes[j][1] < envelopes[i][1]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            res = Math.max(res, max);
        }
        return res;
    }
}
