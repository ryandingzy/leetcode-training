// My solution 超时
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int mul = k * 10000;
        int[][] dp = new int[n+1][k];
        for (int i = 1; i < n; i++) {
            int remain = (mul + nums[i-1]) % k;
            for (int j = 0; j < k; j++) {
                int x = (j + k - remain) % k;
                dp[i][j] = dp[i-1][x];
                if (remain == j) dp[i][j] += 1;
            }
        }
        int r = (mul + nums[n - 1]) % k;
        int x = (k - r) % k;
        dp[n][0] = dp[n-1][x];
        if (r == 0) dp[n][0] += 1;
        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            res += dp[i][0];
        }
        return res;
    }
}

// Better solution
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : nums) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % k + k) % k;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }
}

