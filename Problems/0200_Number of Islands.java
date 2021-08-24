// my solution dfs
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                count++;
                queue.offer(new int[]{i, j});
                grid[i][j] = '0';
                while (!queue.isEmpty()) {
                    int[] pos = queue.poll();
                    if (pos[0] - 1 >= 0 && grid[pos[0]-1][pos[1]] == '1') {
                        queue.offer(new int[]{pos[0] - 1, pos[1]});
                        grid[pos[0]-1][pos[1]] = '0';
                    }
                    if (pos[0] + 1 < m && grid[pos[0]+1][pos[1]] == '1') {
                        queue.offer(new int[]{pos[0] + 1, pos[1]});
                        grid[pos[0]+1][pos[1]] = '0';
                    }
                    if (pos[1] - 1 >= 0 && grid[pos[0]][pos[1]-1] == '1') {
                        queue.offer(new int[]{pos[0], pos[1] - 1});
                        grid[pos[0]][pos[1]-1] = '0';
                    }
                    if (pos[1] + 1 < n && grid[pos[0]][pos[1]+1] == '1') {
                        queue.offer(new int[]{pos[0], pos[1] + 1});
                        grid[pos[0]][pos[1]+1] = '0';
                    }
                }
            }
        }
        return count;
    }
}
