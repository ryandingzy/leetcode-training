class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> lst = new ArrayList<>();
        if (s.length() < 11) return lst;
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            if (!map.containsKey(str)) map.put(str, false);
            else if (!map.get(str)) {
                lst.add(str);
                map.put(str, true);
            }
        }
        return lst;
    }
}
