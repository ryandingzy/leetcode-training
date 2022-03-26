class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] prefixSum = new int[len + 1];
        
        int temp = 0;
        for (int i = 0; i < len; i++) {
            temp += nums[i];
            prefixSum[i+1] = temp;
        }
        
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len + 1; j++) {
                if (prefixSum[j] - prefixSum[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }
}

// better method
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
