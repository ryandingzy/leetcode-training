class Solution {
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    
    public int search(int[] nums, int start, int end) {
        if (start == end) return start;
        int mid = (start + end) / 2;
        if (nums[start+1] < nums[start]) return start;
        if (nums[end-1] < nums[end]) return end;
        if (nums[mid] < nums[mid - 1]) return search(nums, start + 1, mid - 1);
        if (nums[mid] < nums[mid + 1]) return search(nums, mid + 1, end - 1);
        return mid;
    }
}
