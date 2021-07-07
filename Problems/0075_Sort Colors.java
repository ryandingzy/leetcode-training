class Solution {
    public void sortColors(int[] nums) {
        int idx = 0;
        int idx0 = 0;
        int idx2 = nums.length - 1;
        int temp;
        while (idx <= idx2) {
            if (nums[idx0] == 0 && idx0 < idx) {
                idx0++;
                continue;
            }
            if (nums[idx2] == 2) {
                idx2--;
                continue;
            }
            if (nums[idx] == 0 && idx > idx0) {
                nums[idx] = nums[idx0];
                nums[idx0] = 0;
                idx0++;
                continue;
            }
            if (nums[idx] == 2 && idx < idx2) {
                nums[idx] = nums[idx2];
                nums[idx2] = 2;
                idx2--;
                continue;
            }
            idx++;
        }
    }
}
