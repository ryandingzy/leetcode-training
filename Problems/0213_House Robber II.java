class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        if (n == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));
        int[] dp1 = new int[n];
        dp1[1] = nums[1];
        dp1[2] = nums[2];
        dp1[3] = nums[3] + nums[1];
        for (int i = 4; i < n; i++) {
            dp1[i] = Math.max(dp1[i-2], dp1[i-3]) + nums[i];
        }
        int[] dp2 = new int[n];
        dp2[n-2] = nums[n-2];
        dp2[n-3] = nums[n-3];
        dp2[n-4] = nums[n-4] + nums[n-2];
        for (int i = n - 5; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i+2], dp2[i+3]) + nums[i];
        }
        return Math.max(Math.max(dp2[0], dp2[1]), Math.max(dp1[n-1], dp1[n-2]));
    }
}


// better solution
class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
