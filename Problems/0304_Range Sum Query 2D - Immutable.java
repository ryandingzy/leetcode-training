class NumMatrix {
    int [][] sums;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sums = new int[m][n];
        sums[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            sums[i][0] = sums[i-1][0] + matrix[i][0];
        }
        for (int j = 1; j < n; j++) {
            sums[0][j] = sums[0][j-1] + matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sums[i][j] = matrix[i][j] + sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) return sums[row2][col2];
        if (row1 == 0) return sums[row2][col2] - sums[row2][col1-1];
        if (col1 == 0) return sums[row2][col2] - sums[row1-1][col2];
        return sums[row2][col2] - sums[row2][col1-1] - sums[row1-1][col2] + sums[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
 