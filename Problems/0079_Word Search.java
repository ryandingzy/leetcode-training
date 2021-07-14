class Solution {
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == arr[0]) {
                    board[i][j] -= 65;
                    if (dfs(board, arr, 0, i, j))
                        return true;
                    board[i][j] += 65;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, char[] word, int idx, int i, int j) {
        if (idx == word.length - 1)
            return true;
        if (i > 0 && word[idx+1] == board[i-1][j]) {
            board[i-1][j] -= 65;
            if (dfs(board, word, idx+1, i-1, j))
                return true;
            board[i-1][j] += 65;
        }
        if (j > 0 && word[idx+1] == board[i][j-1]) {
            board[i][j-1] -= 65;
            if (dfs(board, word, idx+1, i, j-1))
                return true;
            board[i][j-1] += 65;
        }
        if (i < board.length - 1 && word[idx+1] == board[i+1][j]) {
            board[i+1][j] -= 65;
            if (dfs(board, word, idx+1, i+1, j))
                return true;
            board[i+1][j] += 65;
        }
        if (j < board[0].length - 1 && word[idx+1] == board[i][j+1]) {
            board[i][j+1] -= 65;
            if (dfs(board, word, idx+1, i, j+1))
                return true;
            board[i][j+1] += 65;
        }
        return false;
    }
}
