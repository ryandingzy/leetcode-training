class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int[] sums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        if (sums[n-1] - sums[0] == 0) return 0;
        for (int i = 1; i < n - 1; i++) {
            if (sums[i-1] == sums[n-1] - sums[i]) {
                return i;
            }
        }
        if (sums[n-2] == 0) return n - 1;
        return -1;
    }
}
