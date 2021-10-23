class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        
        int[] ids = new int[nums1.length];
        
        while (res.size() < k && res.size() < nums1.length * nums2.length) {
            int id = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums1.length; i++) {
                if (ids[i] < nums2.length && nums1[i] + nums2[ids[i]] < min) {
                    id = i;
                    min = nums1[i] + nums2[ids[i]];
                }
            }
            res.add(new ArrayList<Integer>());
            res.get(res.size() - 1).add(nums1[id]);
            res.get(res.size() - 1).add(nums2[ids[id]]);
            ids[id]++;
        }
        return res;
    }
}


// 还可以用priorityqueue可以简化寻找最小sum的过程
