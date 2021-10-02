class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> lst = new ArrayList<>();
        int last = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == last) {
                last++;
            } else {
                if (nums[i] - 1 == last) {
                    lst.add(Integer.toString(last));
                } else {
                    lst.add(Integer.toString(last) + "->" + Integer.toString(nums[i] - 1));
                }
                last = nums[i] + 1;
            }
        }
        if (last == upper) lst.add(Integer.toString(upper));
        else if (last < upper) lst.add(Integer.toString(last) + "->" + Integer.toString(upper));
        return lst;
    }
}
