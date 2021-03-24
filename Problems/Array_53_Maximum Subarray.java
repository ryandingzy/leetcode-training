class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(sum, res);
        }
        return res;
    }

    // 动态规划标准形式
    // public int maxSubArray(int[] nums) {
	// 	int[] dp = new int[nums.length];
	// 	dp[0] = nums[0];
	// 	int max = nums[0];
	// 	for (int i = 1; i < nums.length; i++) {
	// 		dp[i] = Math.max(dp[i- 1] + nums[i], nums[i]);	
	// 		if (max < dp[i]) {
	// 			max = dp[i];
	// 		}
	// 	}
	// 	return max;
	// }
}

