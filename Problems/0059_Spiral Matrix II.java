class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int state = 0; // 0-right, 1-down, 2-left, 3-up
        int i = 0, j = 0;
        while (true) {
            matrix[i][j] = count;
            if (count == n * n)
                return matrix;
            
            // cal next
            if (state == 0) {
                if (j + 1 >= n || matrix[i][j+1] != 0) {
                    i++;
                    state = 1;
                } else {
                    j++;
                }
            } else if (state == 1) {
                if (i + 1 >= n || matrix[i+1][j] != 0) {
                    j--;
                    state = 2;
                } else {
                    i++;
                }
            } else if (state == 2) {
                if (j - 1 < 0 || matrix[i][j-1] != 0) {
                    i--;
                    state = 3;
                } else {
                    j--;
                }
            } else {
                if (matrix[i-1][j] != 0) {
                    j++;
                    state = 0;
                } else {
                    i--;
                }
            }
            count++;
        }
    }
}
