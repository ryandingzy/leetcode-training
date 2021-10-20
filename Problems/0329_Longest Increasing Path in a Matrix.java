class Solution {
    private int[] rowDir = {0, 0, 1, -1};
    private int[] colDir = {1, -1, 0, 0};
    
    private int[][] length;
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        length = new int[m][n];
        for (int[] arr : length) {
            Arrays.fill(arr, -1);
        }
        
        int len = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (length[i][j] == -1)
                    bfs(matrix, i, j);
                len = Math.max(len, length[i][j]);
            }
        }
        return len;
    }
    
    private int bfs(int[][] matrix, int row, int col) {
        if (length[row][col] != -1) return length[row][col];
        
        int maxLen = 1;
        for (int i = 0; i < 4; i++) {
            if (isValid(matrix, row + rowDir[i], col + colDir[i], matrix[row][col])) {
                maxLen = Math.max(maxLen, 1 + bfs(matrix, row + rowDir[i], col + colDir[i]));
            }
        }
        length[row][col] = maxLen;
        return maxLen;
    }
    
    private boolean isValid(int[][] matrix, int row, int col, int num) {
        if (row < 0 || row >= matrix.length) return false;
        if (col < 0 || col >= matrix[0].length) return false;
        return matrix[row][col] > num;
    }
}
