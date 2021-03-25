class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int l;
        int r;
        int sum = Integer.MAX_VALUE;
        int res = sum;
        int diff;
        for (int i = 0; i < nums.length - 2; i++) {
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                if (l > i + 1 && nums[l] == nums[l - 1]) {
                    l++;
                    continue;
                }
                if (r < nums.length - 1 && nums[r] == nums[r + 1]) {
                    r--;
                    continue;
                }
                sum = nums[i] + nums[l] + nums[r];
                diff = sum - target;
                if (res == Integer.MAX_VALUE || Math.abs(diff) < Math.abs(res - target)) {
                    res = sum;
                }
                if (diff == 0) {
                    return res;
                } else if (diff > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}
