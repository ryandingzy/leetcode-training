class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) return false;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = nums[0];
        map.put(sum % k, 0);
        for (int i = 1; i < len; i++) {
            sum += nums[i];
            int key = sum % k;
            if (key == 0)
                return true;
            if (map.containsKey(key)) {
                if (map.get(key) < i - 1) {
                    return true;
                }
            } else {
                map.put(key, i);
            }
        }
        return false;
    }
}
