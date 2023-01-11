class Solution {
    private int[][] d = new int[][]{
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    private boolean isLand(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i >= 0 && i < m && j >= 0 && j < n) {
            return grid[i][j] == 1;
        }
        return false;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    Deque<int[]> stack = new ArrayDeque<>();
                    stack.addLast(new int[]{i, j});
                    int area = 1;
                    while (!stack.isEmpty()) {
                        int[] pos = stack.pollLast();
                        for (int[] id : d) {
                            int row = pos[0] + id[0];
                            int col = pos[1] + id[1];
                            if (isLand(grid, row, col)) {
                                area++;
                                grid[row][col] = -1;
                                stack.addLast(new int[]{row, col});
                            }
                        }
                    }
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }
}
