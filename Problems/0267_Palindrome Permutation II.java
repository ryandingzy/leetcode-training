class Solution {
    HashMap<Character, Integer> map = new HashMap<>();
    char oddKey = '\0';
    
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        // add
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        // check
        boolean isOdd = n % 2 == 1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                if (!isOdd) return res;
                else {
                    oddKey = entry.getKey();
                    isOdd = false;
                }
            }
        }
        // produce
        StringBuilder sb = new StringBuilder();
        dfs(0, n, sb, res);
        return res;
    }
    
    public void dfs(int i, int n, StringBuilder sb, List<String> res) {
        if (i == n / 2) {
            int length = sb.length();
            if (n % 2 == 1) {
                sb.append(oddKey);
            }
            for (i--; i >= 0; i--) {
                sb.append(sb.charAt(i));
            }
            res.add(sb.toString());
            sb.setLength(length);
            return;
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            
            if (value <= 1) continue;
            
            sb.append(key);
            map.put(key, value - 2);
            dfs(i + 1, n, sb, res);
            map.put(key, value);
            sb.setLength(sb.length() - 1);
        }
    }
}
