class Solution {
    private boolean compare(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getArr(String s, int start, int end) {
        int[] res = new int[26];
        for (int i = start; i < end; i++) {
            res[s.charAt(i) - 'a']++;
        }
        return res;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int len = p.length();
        int[] ps = getArr(p, 0, len);

        for (int i = 0; i < s.length() - len + 1; i++) {
            int[] tmp = getArr(s, i, i + len);
            if (compare(ps, tmp)) {
                res.add(i);
            }
        }
        return res;
    }
}
