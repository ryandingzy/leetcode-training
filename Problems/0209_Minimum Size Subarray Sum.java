class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = -1, r = -1;
        int sum = 0;
        int count = 0;
        int res = Integer.MAX_VALUE;
        boolean rightMove = true;
        while (true) {
            if (rightMove) {
                r++;
                if (r == nums.length) break;
                count++;
                sum += nums[r];
                if (sum >= target) {
                    res = Math.min(res, count);
                    rightMove = false;
                }
            } else {
                l++;
                count--;
                sum -= nums[l];
                if (sum >= target) {
                    res = Math.min(res, count);
                } else {
                    rightMove = true;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

// binary search
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1]; 
        // 为了方便计算，令 size = n + 1 
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
