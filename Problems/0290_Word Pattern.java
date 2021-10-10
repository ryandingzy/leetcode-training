class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) return false;
        for (int i = 0; i < strs.length; i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (set.contains(strs[i])) return false;
                map.put(pattern.charAt(i), strs[i]);
                set.add(strs[i]);
            } else {
                if (!map.get(pattern.charAt(i)).equals(strs[i])) return false;
            }
        }
        return true;
    }
}
