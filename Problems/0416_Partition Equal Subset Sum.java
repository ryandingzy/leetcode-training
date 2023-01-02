// My solution is to set j as the difference between two parts
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int ROW = 100 * 100;
        boolean[][] dp = new boolean[n + 1][ROW];
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < ROW; j++) {
                dp[i][j] = dp[i][j] || dp[i-1][Math.abs(j - nums[i-1])];
                if (j + nums[i-1] < ROW) {
                    dp[i][j] = dp[i][j] || dp[i-1][j + nums[i-1]];
                }
            }
        }
        dp[n][0] = dp[n-1][nums[n-1]];
        return dp[n][0];
    }
}

// Better solution

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }
}
