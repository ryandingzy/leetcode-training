class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        
        int f = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            f += nums[i] * i;
            sum += nums[i];
        }
        
        int res = f;
        for (int i = 1; i < n; i++) {
            f = f + sum - n * nums[n - i];
            res = Math.max(res, f);
        }
        return res;
    }
}
