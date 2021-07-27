// My Solution
class Solution {
    public boolean search(int[] nums, int target) {
        int k = 0;
        if (nums[nums.length - 1] <= nums[0]) {
            k = bSearchK(nums, 0, nums.length - 1);
        }
        return bSearch(nums, target, k, 0, nums.length - 1);
    }
    
    public int bSearchK(int[] nums, int l, int r) {
        if (l > r)
            return 0;
        if (nums[l] < nums[r])
            return nums.length - l;
        int m = (l + r) / 2;
        if (m > 0 && nums[m - 1] > nums[m])
            return nums.length - m;
        if (nums[m] > nums[l])
            return bSearchK(nums, m + 1, r);
        else if (nums[m] < nums[l])
            return bSearchK(nums, l, m - 1);
        else {
            int res = bSearchK(nums, m + 1, r);
            if (res != 0)
                return res;
            return bSearchK(nums, l, m - 1);
        }
    }
    
    public boolean bSearch(int[] nums, int target, int k, int l, int r) {
        if (l > r)
            return false;
        int m = (l + r) / 2;
        if (nums[(m - k + nums.length) % nums.length] == target) {
            return true;
        } else if (nums[(m - k + nums.length) % nums.length] > target) {
            return bSearch(nums, target, k, l, m - 1);
        } else {
            return bSearch(nums, target, k, m + 1, r);
        }
    }
}

// Better Solution
public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }
            //前半部分有序
            if (nums[start] < nums[mid]) {
                //target在前半部分
                if (nums[mid] > target && nums[start] <= target) {
                    end = mid - 1;
                } else {  //否则，去后半部分找
                    start = mid + 1;
                }
            } else {
                //后半部分有序
                //target在后半部分
                if (nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {  //否则，去后半部分找
                    end = mid - 1;

                }
            }
        }
        //一直没找到，返回false
        return false;

    }
