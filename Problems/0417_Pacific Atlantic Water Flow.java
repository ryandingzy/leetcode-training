class Solution {
    int[][] direct = new int[][] {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        int[][] ocean = new int[m][n];
        
        // Pacific Ocean
        boolean[][] pVisited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            pVisited[0][i] = true;
            queue.offer(new int[]{0, i});
        }
        for (int i = 1; i < m; i++) {
            pVisited[i][0] = true;
            queue.offer(new int[]{i, 0});
        }
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            ocean[pos[0]][pos[1]]++;
            
            for (int i = 0; i < direct.length; i++) {
                int row = pos[0] + direct[i][0];
                int col = pos[1] + direct[i][1];
                if (!check(heights, pVisited, row, col))
                    continue;
                if (heights[row][col] < heights[pos[0]][pos[1]])
                    continue;
                pVisited[row][col] = true;
                queue.offer(new int[]{row, col});
            }
        }
        
        // Atlantic
        pVisited = new boolean[m][n];
        
        for (int i = 0; i < n; i++) {
            pVisited[m - 1][i] = true;
            queue.offer(new int[]{m - 1, i});
        }
        for (int i = 0; i < m - 1; i++) {
            pVisited[i][n - 1] = true;
            queue.offer(new int[]{i, n - 1});
        }
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            ocean[pos[0]][pos[1]]++;
            
            for (int i = 0; i < direct.length; i++) {
                int row = pos[0] + direct[i][0];
                int col = pos[1] + direct[i][1];
                if (!check(heights, pVisited, row, col))
                    continue;
                if (heights[row][col] < heights[pos[0]][pos[1]])
                    continue;
                pVisited[row][col] = true;
                queue.offer(new int[]{row, col});
            }
        }
        
        // get result
        List<List<Integer>> lst = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ocean[i][j] == 2) {
                    lst.add(Arrays.asList(i, j));
                }
            }
        }
        return lst;
    }
    
    private boolean check(int[][] heights, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= heights.length)
            return false;
        if (col < 0 || col >= heights[0].length)
            return false;
        if (visited[row][col])
            return false;
        return true;
    }
}

// BFS
