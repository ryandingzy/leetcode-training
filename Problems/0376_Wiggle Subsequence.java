class Solution {
    public int wiggleMaxLength(int[] nums) {
        boolean curPositive = true;
        
        int positiveFirst = getLength(nums, true);
        int negativeFirst = getLength(nums, false);
        return Math.max(positiveFirst, negativeFirst);
    }
    
    public int getLength(int[] nums, boolean curPositive) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (curPositive) {
                if (nums[i] > nums[i-1]) {
                    count++;
                    curPositive = false;
                }
            } else {
                if (nums[i] < nums[i-1]) {
                    count++;
                    curPositive = true;
                }
            }
        }
        return count;
    }
}
