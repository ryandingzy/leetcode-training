class Solution {
    public int findMin(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    
    public int search(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int mid = (start + end) / 2;
        if (mid == start) return Math.min(nums[start], nums[end]);
        if (nums[start] < nums[mid]) return Math.min(nums[start], search(nums, mid + 1, end));
        else if (nums[start] > nums[mid]) return search(nums, start + 1, mid);
        else return Math.min(search(nums, start, mid - 1), search(nums, mid + 1, end));
    }
}
