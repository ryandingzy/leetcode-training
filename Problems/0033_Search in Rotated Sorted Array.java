class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int i = (l + r) / 2;
        while (true) {
            if (nums[i] == target)
                return i;
            if (r <= l)
                return -1;
            if (nums[i] < nums[l]) {
                if (target >= nums[l] || target < nums[i]) {
                    r = i - 1;
                    i = (l + r) / 2;
                    continue;
                }
            } else {
                if (target >= nums[l] && target < nums[i]) {
                    r = i - 1;
                    i = (l + r) / 2;
                    continue;
                }
            }
            l = i + 1;
            i = (l + r) / 2;
        }
    }
}
