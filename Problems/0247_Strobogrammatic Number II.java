class Solution {
    int[] candidates = new int[] {0, 1, 8, 6, 9};
    
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i < 3; i++) {
                res.add(Integer.toString(candidates[i]));
            }
            return res;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 5; i++) {
            sb.append(candidates[i]);
            dfs(sb, n, res);
            sb.setLength(sb.length() - 1);
        }
        return res;
    }
    
    public void dfs(StringBuilder sb, int n, List<String> res) {
        if (sb.length() >= n / 2) {
            if (n % 2 == 1) {
                for (int i = 0; i < 3; i++) {
                    sb.append(candidates[i]);
                    addResult(sb, n, res);
                    sb.setLength(sb.length() - 1);
                }
            } else {
                addResult(sb, n, res);
            }
            return;
        } else {
            for (int i = 0; i < 5; i++) {
                sb.append(candidates[i]);
                dfs(sb, n, res);
                sb.setLength(sb.length() - 1);
            }
        }
    }
    public void addResult(StringBuilder sb, int n, List<String> res) {
        int length = sb.length();
        for (int i = n / 2 - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '6') sb.append('9');
            else if (c == '9') sb.append('6');
            else sb.append(c);
        }
        res.add(sb.toString());
        sb.setLength(length);
    }
}
