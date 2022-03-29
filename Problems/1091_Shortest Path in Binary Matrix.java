class Solution {
    int[][] move = new int[][]{
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1},
        {1, 1},
        {1, -1},
        {-1, 1},
        {-1, -1}
    };
    private boolean canReach(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (r < 0 || r >= m) return false;
        if (c < 0 || c >= n) return false;
        return grid[r][c] == 0;
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] != 0 || grid[m-1][n-1] != 0) {
            return -1;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        grid[m-1][n-1] = 1;
        if (m - 1 == 0 && n - 1 == 0) {
            return 1;
        }
        queue.offer(new int[]{m-1, n-1});
        int count = 1, next = 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int layer = grid[pos[0]][pos[1]] + 1;
            for (int i = 0; i < 8; i++) {
                int row = pos[0] + move[i][0];
                int col = pos[1] + move[i][1];
                if (canReach(grid, row, col)) {
                    if (row == 0 && col == 0) {
                        return layer;
                    }
                    grid[row][col] = layer;
                    queue.offer(new int[]{row, col});
                    next++;
                }
            }
        }
        return -1;
    }
}
