class Solution {
    public boolean canJump(int[] nums) {
        int idx1 = 0;
        int idx2 = 0;
        while (true) {
            idx2 = Math.max(idx2, idx1 + nums[idx1]);
            if (idx2 >= nums.length - 1) return true;
            if (idx1 == idx2) return false;
            idx1++;
        }
    }
}