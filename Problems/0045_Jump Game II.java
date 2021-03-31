class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        nums[nums.length - 1] = 0;
        int min;
        for (int i = nums.length - 2; i >= 0; i--) {
            min = 100000;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j <= nums.length - 1) {
                    min = Math.min(min, nums[i+j]);
                } else {
                    break;
                }
            }
            nums[i] = min + 1;
        }
        return nums[0];
    }
}

// better solution (Greedy Algorithm)
/*
class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0; 
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]); 
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
*/