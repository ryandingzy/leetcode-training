// My solution -- TLE
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        
        int max = 0;
        for (int i = n - 1; i >= 0 && i > max - 1; i--) {
            if (sum[i] == k) return i + 1;
            for (int j = 0; j < i - max; j++) {
                if (sum[i] - sum[j] == k) {
                    max = Math.max(max, i - j);
                }
            }
        }
        return max;
    }
}

// better solution
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int prefixSum = 0;
        int longestSubarray = 0;
        HashMap<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // Check if all of the numbers seen so far sum to k.
            if (prefixSum == k) {
                longestSubarray = i + 1;
            }

            // If any subarray seen so far sums to k, then
            // update the length of the longest_subarray. 
            if (indices.containsKey(prefixSum - k)) {
                longestSubarray = Math.max(longestSubarray, i - indices.get(prefixSum - k));
            }
            
            // Only add the current prefix_sum index pair to the 
            // map if the prefix_sum is not already in the map.
            if (!indices.containsKey(prefixSum)) {
                indices.put(prefixSum, i);
            }
        }
        
        return longestSubarray;
    }
}
