class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int cur = 0;
        int pre = 0;
        if (nums.length > 0) {
            res = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cur++;
                res = Math.max(res, cur + pre + 1);
            } else {
                if (i < nums.length - 1 && nums[i+1] == 1) {
                    pre = cur;
                    i++;
                    cur = 1;
                    res = Math.max(res, cur + pre + 1);                    
                } else {
                    pre = 0;
                    i++;
                    cur = 0;
                }
            }
        }
        if (res == nums.length + 1) {
            return res - 1;
        } else {
            return res;
        }
    }
}
