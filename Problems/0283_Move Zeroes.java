class Solution {
    public void moveZeroes(int[] nums) {
        int p0 = 0;
        while (p0 < nums.length && nums[p0] != 0) p0++;
        int p = p0 + 1;
        while (p < nums.length) {
            if (nums[p] != 0) {
                nums[p0] = nums[p];
                p0++;
            }
            p++;
        }
        while (p0 < nums.length) {
            nums[p0] = 0;
            p0++;
        }
    }
}
