class Solution {
    private int[] rowDir = {0, 0, 1, -1};
    private int[] colDir = {1, -1, 0, 0};
    
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int rows = grid.length, cols = grid[0].length;
        
        int[][] canReach = new int[rows][cols];
        int[][] dist = new int[rows][cols];
        
        int totalBuildings = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    bfs(grid, i, j, canReach, dist);
                }
            }
        }
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canReach[i][j] == totalBuildings && dist[i][j] < minDist) {
                    minDist = dist[i][j];
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
    
    private void bfs(int[][] grid, int row, int col, int[][] canReach, int[][] dist) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int d = 0;
        q.offer(new int[]{row, col});
        visited[row][col] = true;
        
        while (!q.isEmpty()) {
            d++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int k = 0; k < 4; k++) {
                    int rr = rowDir[k] + cur[0];
                    int cc = colDir[k] + cur[1];
                    
                    if (!isValid(grid, rr, cc, visited)) continue;
                    visited[rr][cc] = true;
                    q.offer(new int[]{rr, cc});
                    dist[rr][cc] += d;
                    canReach[rr][cc]++;
                }
            }
        }
    }
    
    private boolean isValid(int[][] grid, int rr, int cc, boolean[][] visited) {
        if (rr < 0 || rr > grid.length - 1 || cc < 0 || cc > grid[0].length - 1)
            return false;
        if (visited[rr][cc]) return false;
        if (grid[rr][cc] != 0) return false;
        return true;
    }
}
