class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1])
                break;
        }
        
        if (i >= 0) {
            int j;
            for (j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i])
                    break;
            }
        
            // Swap
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        
        // reverse
        int idx1 = i + 1, idx2 = nums.length - 1;
        int temp;
        while (idx1 < idx2) {
            temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
            idx1++;
            idx2--;
        }
    }
}