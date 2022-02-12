class Solution {
    int[][] direct = new int[][]{
        {-1, 1, 0, 0},
        {0, 0, 1, -1}
    };
    public int orangesRotting(int[][] grid) {
        // traverse
        int numOrange = 0;
        int numIteration = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) numOrange++;
                if (grid[i][j] == 1) numIteration++;
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        // iteration
        int step = 0;
        while (queue.size() < numOrange && numIteration-- > 0) {
            int size = queue.size();
            while (size-- > 0) {
                int[] pos = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int row = pos[0] + direct[0][i];
                    int col = pos[1] + direct[1][i];
                    if (isGood(grid, row, col)) {
                        grid[row][col] = 2;
                        queue.offer(new int[]{row, col});
                    }
                }
                queue.offer(pos);
            }
            step++;
        }
        return numIteration == -1 ? -1 : step;
    }
    
    private boolean isGood(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (row < 0 || row >= m) return false;
        if (col < 0 || col >= n) return false;
        return grid[row][col] == 1;
    }
}
