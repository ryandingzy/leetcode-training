class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int nbrLive = 0;
                if (i - 1 >= 0) {
                    if (board[i-1][j] % 10 == 1) nbrLive++;
                    if (j - 1 >= 0 && board[i-1][j-1] % 10 == 1) nbrLive++;
                    if (j + 1 < n && board[i-1][j+1] % 10 == 1) nbrLive++;
                }
                if (i + 1 < m) {
                    if (board[i+1][j] % 10 == 1) nbrLive++;
                    if (j - 1 >= 0 && board[i+1][j-1] % 10 == 1) nbrLive++;
                    if (j + 1 < n && board[i+1][j+1] % 10 == 1) nbrLive++;
                }
                if (j - 1 >= 0 && board[i][j-1] % 10 == 1) nbrLive++;
                if (j + 1 < n && board[i][j+1] % 10 == 1) nbrLive++;
                // judge
                if (board[i][j] == 1) {
                    if (nbrLive == 2 || nbrLive == 3) board[i][j] += 10;
                } else {
                    if (nbrLive == 3) board[i][j] += 10;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] /= 10;
            }
        }
    }
}
