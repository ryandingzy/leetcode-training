class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] pos = new int[len];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = dp[pos[0]] * primes[0];
            for (int j = 1; j < len; j++) {
                min = Math.min(min, dp[pos[j]] * primes[j]);
            }
            for (int j = 0; j < len; j++) {
                if (dp[pos[j]] * primes[j] == min) {
                    pos[j]++;
                }
            }
            dp[i] = min;
        }
        return dp[n-1];
    }
}
