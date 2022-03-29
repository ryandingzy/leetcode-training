class Solution {
    HashMap<Integer, Integer> idCount;
    int res;
    
    int[][] move = new int[][]{
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    
    Deque<int[]> stack;
    
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        idCount = new HashMap<>();
        
        stack = new ArrayDeque<>();
        
        int id = 0;
        res = 0;
        int[][] ids = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    idCount.put(id, 0);
                    dfs(grid, i, j, id);
                    print(grid, ids, id);
                    id++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    calVal(grid, ids, i, j);
                }
            }
        }
        return res;
    }
    
    private void print(int[][] grid, int[][] ids, int id) {
        int count = idCount.get(id);
        res = Math.max(res, count);
        while (!stack.isEmpty()) {
            int[] pos = stack.pollLast();
            ids[pos[0]][pos[1]] = id;
            grid[pos[0]][pos[1]] = count;
        }
    }
    
    private void dfs(int[][] grid, int r, int c, int id) {
        idCount.put(id, idCount.get(id) + 1);
        grid[r][c] = -1;
        stack.addLast(new int[]{r, c});
        for (int i = 0; i < 4; i++) {
            int row = r + move[i][0];
            int col = c + move[i][1];
            if (canReach(grid, row, col)) {
                dfs(grid, row, col, id);
            }
        }
    }
    
    private boolean isSafe(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (r < 0 || r >= m) return false;
        if (c < 0 || c >= n) return false;
        return true;
    }
    
    private boolean canReach(int[][] grid, int r, int c) {
        return isSafe(grid, r, c) && grid[r][c] == 1;
    }
    
    private void calVal(int[][] grid, int[][] ids, int r, int c) {
        int val = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            int row = r + move[i][0];
            int col = c + move[i][1];
            if (isSafe(grid, row, col) && grid[row][col] > 0) {
                int id = ids[row][col];
                if (!set.contains(id)) {
                    val += grid[row][col];
                    set.add(id);
                }
            }
        }
        res = Math.max(res, val + 1);
    }
}
