class Solution {
    int number = 0;
    public int totalNQueens(int n) {
        int[][] mark = new int[n][n];
        // -1 queen, 0 safe place
        dfs(mark, n, 0);
        return number;
    }
    public void dfs(int[][] mark, int n, int row) {
        if (row == n) {
            number++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (mark[row][col] == 0) {
                int i, j;
                for (i = row + 1; i < n; i++) mark[i][col]++;
                i = row + 1; j = col -1;
                while (i < n && j >= 0) mark[i++][j--]++;
                i = row + 1; j = col + 1;
                while (i < n && j < n) mark[i++][j++]++;
                
                dfs(mark, n, row+1);
                
                for (i = row + 1; i < n; i++) mark[i][col]--;
                i = row + 1; j = col - 1;
                while (i < n && j >= 0) mark[i++][j--]--;
                i = row + 1; j = col + 1;
                while (i < n && j < n) mark[i++][j++]--;
            }
        }
    }
}
