class Solution {
    public List<List<String>> partition(String s) {
        // dp
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i < len - 1) {
                dp[i][i+1] = s.charAt(i+1) == s.charAt(i) ? true : false;
            }
        }
        for (int j = 2; j < len; j++) {
            for (int i = 0; i + j < len; i++) {
                dp[i][j+i] = s.charAt(i) == s.charAt(j+i) ? dp[i+1][j+i-1] : false;
            }
        }
        
        // dfs
        List<List<String>> lsts = new ArrayList<>();
        List<String> lst = new ArrayList<>();
        dfs(s, 0, dp, lst, lsts);
        return lsts;
    }
    
    public void dfs(String s, int start, boolean[][] dp, List<String> lst, List<List<String>> lsts) {
        for (int i = 0; i + start < s.length(); i++) {
            if (dp[start][start+i]) {
                lst.add(s.substring(start, start + i + 1));
                if (start + i == s.length() - 1) {
                    lsts.add(new ArrayList<>(lst));
                } else {
                    dfs(s, start + i + 1, dp, lst, lsts);
                }
                lst.remove(lst.size() - 1);
            }
        }
    }
}
