class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) 
            return nums.length;
        int idx = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[idx-1])
                continue;
            idx++;
            nums[idx] = nums[i];
        }
        return idx + 1;
    }
}
