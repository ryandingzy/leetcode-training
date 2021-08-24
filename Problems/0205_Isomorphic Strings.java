class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int len = s.length();
        if (t.length() != len) return false;
        if (len == 1) return true;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.get(s.charAt(i)).add(i);
            } else {
                List<Integer> lst = new ArrayList<>();
                lst.add(i);
                map.put(s.charAt(i), lst);
            }
        }
        Set<Character> set = new HashSet<>();
        for (List<Integer> lst : map.values()) {
            char cur = t.charAt(lst.get(0));
            if (set.contains(cur)) return false;
            set.add(cur);
            for (int i = 1; i < lst.size(); i++) {
                if (t.charAt(lst.get(i)) != cur) return false;
            }
        }
        return true;
    }
}
