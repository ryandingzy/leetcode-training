class Solution {
    public void solve(char[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') bfs(board, 0, i);
            if (board[board.length - 1][i] == 'O') bfs(board, board.length - 1, i);
        }
        for (int i = 1; i <= board.length - 2; i++) {
            if (board[i][0] == 'O') bfs(board, i, 0);
            if (board[i][board[0].length - 1] == 'O') bfs(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public void bfs(char[][] board, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        board[i][j] = 'A';
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            if (pos[0] - 1 >= 0 && board[pos[0] - 1][pos[1]] == 'O') {
                board[pos[0] - 1][pos[1]] = 'A';
                queue.offer(new int[]{pos[0] - 1, pos[1]});
            }
            if (pos[0] + 1 < board.length && board[pos[0] + 1][pos[1]] == 'O') {
                board[pos[0] + 1][pos[1]] = 'A';
                queue.offer(new int[]{pos[0] + 1, pos[1]});
            }
            if (pos[1] - 1 >= 0 && board[pos[0]][pos[1] - 1] == 'O') {
                board[pos[0]][pos[1] - 1] = 'A';
                queue.offer(new int[]{pos[0], pos[1] - 1});
            }
            if (pos[1] + 1 < board[0].length && board[pos[0]][pos[1] + 1] == 'O') {
                board[pos[0]][pos[1] + 1] = 'A';
                queue.offer(new int[]{pos[0], pos[1] + 1});
            }
        }
    }
}
