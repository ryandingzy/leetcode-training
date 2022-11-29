class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        int res = 0;
        int l = 0;
        int r = 1;
        int diff = nums[r] - nums[l];
        while (r < n - 1) {
            int newDiff = nums[r+1] - nums[r];
            if (newDiff == diff) {
                res += r - l;
            } else {
                l = r;
                diff = newDiff;
            }
            r++;
        }
        return res;
    }
}
