class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                lst.add(i);
                set.remove(i);
            }
        }
        int[] res = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) res[i] = lst.get(i);
        return res;
    }
}
