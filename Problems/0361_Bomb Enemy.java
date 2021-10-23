// My solution
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] count = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'E') {
                    // left
                    for (int jj = j - 1; jj >= 0; jj--) {
                        if (grid[i][jj] == 'W') break;
                        if (grid[i][jj] == '0') count[i][jj]++;
                    }
                    // right
                    for (int jj = j + 1; jj < n; jj++) {
                        if (grid[i][jj] == 'W') break;
                        if (grid[i][jj] == '0') count[i][jj]++;
                    }
                    // up
                    for (int ii = i - 1; ii >= 0; ii--) {
                        if (grid[ii][j] == 'W') break;
                        if (grid[ii][j] == '0') count[ii][j]++;
                    }
                    // down
                    for (int ii = i + 1; ii < m; ii++) {
                        if (grid[ii][j] == 'W') break;
                        if (grid[ii][j] == '0') count[ii][j]++;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, count[i][j]);
            }
        }
        return max;
        
    }
    
}

// dynamic programming
