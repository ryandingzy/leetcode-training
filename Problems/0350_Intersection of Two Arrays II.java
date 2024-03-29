class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> lst = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) != 0) {
                lst.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] res = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++)
            res[i] = lst.get(i);
        return res;
    }
}
