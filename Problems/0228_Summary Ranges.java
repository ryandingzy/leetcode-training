class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int start = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i+1] > nums[i] + 1) {
                if (nums[i] == start) {
                    res.add(Integer.toString(start));
                } else {
                    res.add(Integer.toString(start) + "->" + Integer.toString(nums[i]));
                }
                if (i != nums.length - 1) start = nums[i+1];
            }
        }
        return res;
    }
}
