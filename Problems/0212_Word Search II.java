class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> lst = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < words.length; i++) {
            boolean found = false;
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (board[row][col] == words[i].charAt(0)) {
                        if (dfs(board, words[i], 1, row, col)) {
                            lst.add(words[i]);
                            found = true;
                            break;
                        }
                    }
                }
                if (found) break;
            }
        }
        return lst;
    }
    public boolean dfs(char[][] board, String word, int idx, int row, int col) {
        if (idx == word.length()) return true;
        board[row][col] = (char)(board[row][col] - 26);
        if (row - 1 >= 0 && board[row-1][col] == word.charAt(idx)) {
            if (dfs(board, word, idx + 1, row - 1, col)) {
                board[row][col] = (char)(board[row][col] + 26);
                return true;
            }
        }
        if (row + 1 < board.length && board[row+1][col] == word.charAt(idx)) {
            if (dfs(board, word, idx + 1, row + 1, col)) {
                board[row][col] = (char)(board[row][col] + 26);
                return true;
            }
        }
        if (col - 1 >= 0 && board[row][col-1] == word.charAt(idx)) {
            if (dfs(board, word, idx + 1, row, col - 1)) {
                board[row][col] = (char)(board[row][col] + 26);
                return true;
            }
        }
        if (col + 1 < board[0].length && board[row][col+1] == word.charAt(idx)) {
            if (dfs(board, word, idx + 1, row, col + 1)) {
                board[row][col] = (char)(board[row][col] + 26);
                return true;
            }
        }
        board[row][col] = (char)(board[row][col] + 26);
        return false;
    }
}
