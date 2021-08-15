class Solution {
    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int[] containMax = new int[nums.length];
        containMax[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                containMax[i] = 0;
                dp[i] = Math.max(dp[i-1], 0);
            } else if (nums[i] > 0) {
                int max = Math.max(containMax[i-1] * nums[i], nums[i]);
                containMax[i] = max;
                dp[i] = Math.max(dp[i-1], max);
            } else {
                int pro = nums[i];
                int max = nums[i];
                int j;
                for (j = i - 1; j >= 0; j--) {
                    if (nums[j] == 0) {
                        max = Math.max(max, Math.max(pro, 0));
                        break;
                    }
                    max = Math.max(max, Math.max(pro, pro * containMax[j]));
                    pro *= nums[j];
                }
                containMax[i] = max;
                dp[i] = Math.max(dp[i-1], max);
            }
        }
        return dp[nums.length - 1];
    }
}

// better solution
class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        for (int i = 1; i < nums.size(); ++i) {
            int mx = maxF, mn = minF;
            maxF = max(mx * nums[i], max(nums[i], mn * nums[i]));
            minF = min(mn * nums[i], min(nums[i], mx * nums[i]));
            ans = max(maxF, ans);
        }
        return ans;
    }
};
