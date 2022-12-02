class Solution {
    public int binarySearch(int[] nums, int l, int r) {
        int diff = r - l;
        if (diff == 0) {
            return nums[l];
        }
        
        int mid = (l + r) / 2;
        
        if (nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid]) {
            return nums[mid];
        } else if (nums[mid-1] == nums[mid]) {
            if (diff == 2) return nums[mid+1];
            if ((mid - 1 - l) % 2 == 1) {
                return binarySearch(nums, l, mid - 2);
            } else {
                return binarySearch(nums, mid + 1, r);
            }
        } else {
            if (diff == 2) return nums[mid-1];
            if ((r - (mid + 1)) % 2 == 1) {
                return binarySearch(nums, mid + 2, r);
            } else {
                return binarySearch(nums, l, mid - 1);
            }
            
        }
    }

    public int singleNonDuplicate(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }
}
