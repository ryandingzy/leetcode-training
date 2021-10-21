class Solution {
    boolean[][] screen = new boolean[3][3];
    int count;
    
    public int numberOfPatterns(int m, int n) {
        count = 0;
        
        for (int row1 = 0; row1 < 3; row1++) {
            for (int col1 = 0; col1 < 3; col1++) {
                screen[row1][col1] = true;
                dfs(row1, col1, 1, m, n);
                screen[row1][col1] = false;
            }
        }
        return count;
    }
    
    private void dfs(int row1, int col1, int seqCount, int m, int n) {
        if (seqCount >= m) count++;
        if (seqCount == n) return;
        
        for (int row2 = 0; row2 < 3; row2++) {
            for (int col2 = 0; col2 < 3; col2++) {
                if (isValid(row1, col1, row2, col2)) {
                    screen[row2][col2] = true;
                    dfs(row2, col2, seqCount + 1, m, n);
                    screen[row2][col2] = false;
                }
            }
        }
    }
    
    private boolean isValid(int row1, int col1, int row2, int col2) {
        if (screen[row2][col2] == true) return false;
        
        if (row1 == row2 && Math.abs(col1 - col2) == 2)
            return screen[row1][1];
        if (col1 == col2 && Math.abs(row1 - row2) == 2)
            return screen[1][col1];
        if (Math.abs(row1 - row2) == 2 && Math.abs(col1 - col2) == 2)
            return screen[1][1];
        return true;
    }
}
