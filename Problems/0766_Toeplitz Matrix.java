class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int r = i, c = 0;
            int num = matrix[r][c];
            while (r < m && c < n) {
                if (matrix[r][c] != num) {
                    return false;
                }
                r++;
                c++;
            }
        }
        
        for (int j = 1; j < n; j++) {
            int r = 0, c = j;
            int num = matrix[r][c];
            while (r < m && c < n) {
                if (matrix[r][c] != num) {
                    return false;
                }
                r++;
                c++;
            }
        }
        return true;
    }
}
