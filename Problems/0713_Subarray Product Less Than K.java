class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int l = 0;
        int r = 0;
        int prod = 1;
        while (r < n) {
            if (prod * nums[r] >= k) {
                if (l == r) {
                    r++;
                } else {
                    res += r - l;
                    prod /= nums[l];
                }
                l++;
            } else {
                prod *= nums[r];
                r++;
            }
        }
        while (l < r) {
            res += r - l;
            l++;
        }
        return res;
    }
}
