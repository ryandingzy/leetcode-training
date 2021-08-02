class Solution {
    char[][] dic = new char[][] {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'},
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> lst = new ArrayList<>();
        if (digits.length() == 0)
            return lst;
        StringBuilder sb = new StringBuilder();
        dfs(digits, 0, sb, lst);
        return lst;
    }
    
    public void dfs(String digits, int i, StringBuilder sb, List<String> lst) {
        if (i == digits.length()) {
            lst.add(sb.toString());
            return;
        }
        
        int digit = digits.charAt(i) - '0';
        for (int j = 0; j < dic[digit - 2].length; j++) {
            sb.append(dic[digit - 2][j]);
            dfs(digits, i + 1, sb, lst);
            sb.deleteCharAt(i);
        }
    }
}
