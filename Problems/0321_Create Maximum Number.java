class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] best = new int[0];
        // 遍历所有分配个数情况，获取构成数字的最大结果
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); ++i)
            best = max(best, 0, maxNumber(maxNumber(nums1, i), maxNumber(nums2, k - i)), 0);
        return best;
    }
    
    // 从数组k个数，构成最大的数
    private int[] maxNumber(int[] nums, int k) {
        int[] ans = new int[k]; // 模拟栈
        int j = 0; // 作为栈顶
        for (int i = 0; i < nums.length; ++i) {
            while (j > 0 && nums[i] > ans[j - 1] && nums.length - i > k - j) --j; // 单调栈，弹出
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }
    
    // 以最大的形式合并两个数
    private int[] maxNumber(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length + nums2.length];
        int s1 = 0;
        int s2 = 0;
        int index = 0;
        while (s1 != nums1.length || s2 != nums2.length)
            ans[index++] = max(nums1, s1, nums2, s2) == nums1 ? nums1[s1++] : nums2[s2++];
        return ans;
    }
    
    // 比较两个数组数字返回最大的那个数组
    private int[] max(int[] nums1, int s1, int[] nums2, int s2) {
        for (int i = s1; i < nums1.length; ++i) {
            int j = s2 + i - s1;
            if (j >= nums2.length) return nums1;
            if (nums1[i] < nums2[j]) return nums2;
            if (nums1[i] > nums2[j]) return nums1;
        }
        return nums2;
    }
}
