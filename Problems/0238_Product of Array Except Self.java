class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int num = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] *= num;
            num *= nums[i];
        }
        num = nums[n-1];
        for (int i = n - 2; i >= 0; i--) {
            res[i] *= num;
            num *= nums[i];
        }
        return res;
    }
}
