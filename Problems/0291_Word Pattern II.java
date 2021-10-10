class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        return dfs(map, pattern, s);
    }
    
    private boolean dfs(HashMap<Character, String> map, String pattern, String s) {
        if (pattern.length() == 0)
            return s.length() == 0;
        
        char key = pattern.charAt(0);
        if (map.containsKey(key)) {
            if (!s.startsWith(map.get(key)))
                return false;
            else {
                return dfs(map, pattern.substring(1), s.substring(map.get(key).length()));
            }
        }
        
        for (int i = 1; i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (map.containsValue(str)) continue;
            map.put(key, str);
            if (dfs(map, pattern.substring(1), s.substring(i))) return true;
            map.remove(key);
        }
        return false;
    }
}
