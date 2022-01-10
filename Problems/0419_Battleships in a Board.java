class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    int row = i + 1, col = j + 1;
                    while (col < n && board[i][col] == 'X') {
                        board[i][col] = '.';
                        col++;
                    }
                    while (row < m && board[row][j] == 'X') {
                        board[row][j] = '.';
                        row++;
                    }
                }
            }
        }
        return count;
    }
}
