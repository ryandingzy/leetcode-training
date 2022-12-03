/*
dp[i] = total number of rewardable student records with i len
1. without A
1) end with P
dp[i] = dp[i-1]

2) end with L
...PLLL
dp[i] = dp[i-1] - dp[i-4]

2. with A
Assume A is in index i
[...i-1] A [i+1....n]
dp[i-1] * dp[n-i]

 */


public class Solution {
    private long M = 1000000007;
    public int checkRecord(int n) {
        long[] dp = new long[n <= 3 ? 4 : n + 1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        dp[3] = 7;

        for (int i = 4; i <= n; i++)
            dp[i] = ((2 * dp[i-1]) % M + (M - dp[i-4]) % M) % M;
        long sum = dp[n];
        for (int i = 1; i <= n; i++) {
            sum += (dp[i-1] * dp[n-i]) % M;
        }
        return (int)(sum % M);
    }
}
