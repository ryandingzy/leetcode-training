class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[][] mark = new int[n][n];
        List<List<String>> lsts = new ArrayList<>();
        dfs(mark, n, 0, lsts);
        return lsts;
    }
    
    public void dfs(int[][] mark, int n, int row, List<List<String>> lsts) {
        if (row == n) {
            List<String> lst = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int j = 0; j < n; j++) {
                    if (mark[i][j] == -1) {
                        str += "Q";
                    } else {
                        str += ".";
                    }
                }
                lst.add(str);
            }
            lsts.add(lst);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (mark[row][i] != 0)
                continue;
            // mark
            mark[row][i] = -1;
            for (int r =  row + 1; r < n; r++) mark[r][i]++;
            for (int ii = i - 1, r = row + 1; ii >= 0 && r < n; ii--, r++) mark[r][ii]++;
            for (int ii = i + 1, r = row + 1; ii < n && r < n; ii++, r++) mark[r][ii]++;
            // operate
            dfs(mark, n, row + 1, lsts);
            // cancel
            mark[row][i] = 0;
            for (int r =  row + 1; r < n; r++) mark[r][i]--;
            for (int ii = i - 1, r = row + 1; ii >= 0 && r < n; ii--, r++) mark[r][ii]--;
            for (int ii = i + 1, r = row + 1; ii < n && r < n; ii++, r++) mark[r][ii]--;
        }
    }
}
