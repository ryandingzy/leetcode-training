class Solution {
    public boolean increasingTriplet(int[] nums) {
        int ni = nums[0];
        int nj = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nj) return true;
            if (nums[i] < ni) ni = nums[i];
            else if (nums[i] != ni && nums[i] < nj) nj = nums[i];
        }
        return false;
    }
}
