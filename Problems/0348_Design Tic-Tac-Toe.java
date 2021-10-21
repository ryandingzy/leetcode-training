class TicTacToe {
    int[][] board;
    int n;
    int dig1 = 0;
    int dig2 = 0;

    public TicTacToe(int n) {
        board = new int[n+1][n+1];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        board[n][col]++;
        board[row][n]++;
        if (row == col) dig1++;
        if (row + col == n - 1) dig2++;
        
        if (board[n][col] == n) {
            int i = 0;
            for (i = 0; i < n; i++) {
                if (board[i][col] != player) break;
            }
            if (i == n) return player;
        }
        if (board[row][n] == n) {
            int i = 0;
            for (i = 0; i < n; i++) {
                if (board[row][i] != player) break;
            }
            if (i == n) return player;
        }
        if (dig1 == n) {
            int i = 0;
            for (i = 0; i < n; i++) {
                if (board[i][i] != player) break;
            }
            if (i == n) return player;
        }
        if (dig2 == n) {
            int i = 0;
            for (i = 0; i < n; i++) {
                if (board[i][n - 1 - i] != player) break;
            }
            if (i == n) return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
 