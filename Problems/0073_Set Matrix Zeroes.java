class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // search and mark
        int[] mark = new int[2];
        if (matrix[0][0] == 0) {
            mark[0] = 1;
            mark[1] = 1;
        } else {
            for (int i = 1; i < m; i++)
                if (matrix[i][0] == 0) {
                    mark[0] = 1; break;
                }
            for (int j = 1; j < n; j++)
                if (matrix[0][j] == 0) {
                    mark[1] = 1; break;
                }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        // write 0
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (mark[0] == 1)
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        if (mark[1] == 1)
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
    }
}
