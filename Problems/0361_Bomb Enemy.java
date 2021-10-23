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
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int maxCount = 0, rowHits = 0;
        int[] colHits = new int[cols];

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {

                // reset the hits on the row, if necessary.
                if (col == 0 || grid[row][col - 1] == 'W') {
                    rowHits = 0;
                    for (int k = col; k < cols; ++k) {
                        if (grid[row][k] == 'W')
                            // stop the scan when we hit the wall.
                            break;
                        else if (grid[row][k] == 'E')
                            rowHits += 1;
                    }
                }

                // reset the hits on the column, if necessary.
                if (row == 0 || grid[row - 1][col] == 'W') {
                    colHits[col] = 0;
                    for (int k = row; k < rows; ++k) {
                        if (grid[k][col] == 'W')
                            break;
                        else if (grid[k][col] == 'E')
                            colHits[col] += 1;
                    }
                }

                // run the calculation for the empty cell.
                if (grid[row][col] == '0') {
                    maxCount = Math.max(maxCount, rowHits + colHits[col]);
                }
            }
        }

        return maxCount;
    }
}