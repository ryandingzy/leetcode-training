class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(word, 0, sb, res);
        return res;
    }
    
    public void dfs(String word, int start, StringBuilder sb, List<String> res) {
        if (start == word.length()) {
            res.add(sb.toString());
            return;
        }
        
        sb.append(word.charAt(start));
        dfs(word, start + 1, sb, res);
        sb.setLength(sb.length() - 1);
        
        if (sb.length() > 0 && Character.isDigit(sb.charAt(sb.length() -1))) return;
        for (int i = 1; i <= word.length() - start; i++) {
            int length = sb.length();
            sb.append(Integer.toString(i));
            dfs(word, start + i, sb, res);
            sb.setLength(length);
        }
    }
}
