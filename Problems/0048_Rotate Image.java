class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length <= 1)
            return;
        int row, col, value;
        int temp;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                row = i;
                col = j;
                value = matrix[row][col];
                for (int k = 0; k < 4; k++) {
                    // update
                    temp = row;
                    row = col;
                    col = matrix.length - 1 - temp;
                    
                    // swap
                    temp = matrix[row][col];
                    matrix[row][col] = value;
                    value = temp;
                }
            }
        }
    }
}

// Easy solution
/*
class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                swap(matrix[i][j], matrix[n - i - 1][j]);
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                swap(matrix[i][j], matrix[j][i]);
            }
        }
    }
};
*/