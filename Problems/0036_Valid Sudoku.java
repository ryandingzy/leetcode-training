class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][][] marks = new boolean[3][9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j] - 48;
                if (num < 1 || num > 9) continue;
                if (marks[0][i][num-1]) return false;
                marks[0][i][num-1] = true;
                if (marks[1][j][num-1]) return false;
                marks[1][j][num-1] = true;
                int pos = i / 3 * 3 + j / 3;
                if (marks[2][pos][num-1]) return false;
                marks[2][pos][num-1] = true;
            }
        }
        return true;
    }
}
