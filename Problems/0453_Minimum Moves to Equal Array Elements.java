class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int each : nums)
            min = Math.min(min, each);
        int res = 0;
        for (int each : nums)
            res += each - min;
        return res;
    }
}
