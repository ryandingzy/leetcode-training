class Solution {
    private boolean check(int[] nums, int m, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > m) {
                if (k == 1) return false;
                k--;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
        int sum = nums[0];
        int n = nums.length;
        if (n == 1) return sum;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        if (k == 1) return sum;
        // binary search
        int l = Math.max(sum / k, max);
        int r = sum;
        while (l < r) {
            int m = (l + r) / 2;
            if (check(nums, m, k)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
