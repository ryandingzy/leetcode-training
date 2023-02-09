class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum1 = nums1[i] + nums2[j];
                map1.put(sum1, map1.getOrDefault(sum1, 0) + 1);
                int sum2 = nums3[i] + nums4[j];
                map2.put(sum2, map2.getOrDefault(sum2, 0) + 1);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            res += entry.getValue() * map2.getOrDefault(0 - entry.getKey(), 0);
        }
        return res;
    }
}
