class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int[] count = new int[32];
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                count[j] += (nums[i] & (1 << j)) == 0 ? 0 : 1;
            }
        }
        
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += count[i] * (n - count[i]);
        }
        
        return res;
    }
    
}
