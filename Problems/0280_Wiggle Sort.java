class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;
        if (n == 2) {
            if (nums[0] > nums[1]) swag(nums, 0, 1);
            return;
        }
        for (int i = 2; i < n; i++) {
            int index = getNum(nums, i, i % 2 == 0);
            if (index != i - 1) swag(nums, i - 1, index);
        }
    }
    private int getNum(int[] nums, int i, boolean getMax) {
        int res = i;
        if (getMax) {
            if (nums[i-2] > nums[res]) res = i-2;
            if (nums[i-1] > nums[res]) res = i-1;
        } else {
            if (nums[i-2] < nums[res]) res = i-2;
            if (nums[i-1] < nums[res]) res = i-1;
        }
        return res;
    }
    
    private void swag(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
