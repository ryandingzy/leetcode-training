class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        
        // search begin
        int b = 0;
        if (nums[0] != target) {
            int l = 0;
            int r = nums.length - 1;
            b = (l + r) / 2;
            while (true) {
                if (l > r)
                    return new int[]{-1, -1};
                if (nums[b] == target) {
                    if (nums[b-1] != target) {
                        break;
                    } else {
                        r = b -1;
                        b = (l + r) / 2;
                    }
                } else if (nums[b] > target) {
                    r = b -1;
                    b = (l + r) / 2;
                } else {
                    l = b + 1;
                    b = (l + r) / 2;
                }
            }
        }
        
        // search end
        int e = nums.length - 1;
        if (nums[nums.length - 1] != target) {
            int l = b;
            int r = nums.length - 1;
            e = (l + r) / 2;
            while (true) {
                if (nums[e] == target) {
                    if (nums[e+1] != target) {
                        break;
                    } else {
                        l = e + 1;
                        e = (l + r) / 2;
                    }
                } else if (nums[e] > target) {
                    r = e - 1;
                    e = (l + r) / 2;
                } else {
                    l = e + 1;
                    e = (l + r) / 2;
                }
            }
        }
        return new int[]{b, e};
    }
}

// better solution
/*
class Solution {
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
}

*/