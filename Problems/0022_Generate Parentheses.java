class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> lst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(2 * n, 1, 0, lst, sb);
        return lst;
    }
    
    public void dfs(int n, int count, int countLeft, List<String> lst, StringBuilder sb) {
        // left
        if (n - count >= countLeft + 1) {
            sb.append('(');
            dfs(n, count + 1, countLeft + 1, lst, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        // right
        if (countLeft > 0) {
            sb.append(')');
            dfs(n, count + 1, countLeft - 1, lst, sb);
            if (count == n) lst.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
