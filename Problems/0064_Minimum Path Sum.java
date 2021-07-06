class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            sum[0][i] = grid[0][i] + sum[0][i-1];
        }
        for (int j = 1; j < m; j++) {
            sum[j][0] = grid[j][0] + sum[j-1][0];
        }
        for (int j = 1; j < m; j++) {
            for (int i = 1; i < n; i++) {
                sum[j][i] = Math.min(sum[j-1][i], sum[j][i-1]) + grid[j][i];
            }
        }
        return sum[m-1][n-1];
    }
}
