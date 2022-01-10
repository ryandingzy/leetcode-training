class Solution {
    int[][] direct = new int[][]{
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] pos = queue.poll();
                        // check
                        for (int k = 0; k < 4; k++) {
                            int row = pos[0] + direct[k][0];
                            int col = pos[1] + direct[k][1];
                            int value = check(grid, row, col);
                            if (value == 0) {
                                res++;
                            } else if (value == 1) {
                                queue.offer(new int[]{row, col});
                                grid[row][col] = -1;
                            }
                        }
                    }
                    return res;
                }
            } 
        }
        return res;
    }
    
    private int check(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length) {
            return 0;
        }
        if (col < 0 || col >= grid[0].length) {
            return 0;
        }
        return grid[row][col];
    }
}

// BFS
