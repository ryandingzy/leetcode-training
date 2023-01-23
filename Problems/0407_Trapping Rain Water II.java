class Solution {
    private int[][] d = new int[][] {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    private boolean outside(int[][] heightMap, int r, int c) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n || heightMap[r][c] == -1) {
            return true;
        }
        return false;
    }

    private boolean border(int[][] heightMap, int x, int y) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        for (int i = 0; i < 4; i++) {
            int r = x + d[i][0];
            int c = y + d[i][1];
            if (outside(heightMap, r, c)) {
                heightMap[x][y] = -1;
                return true;
            }
        }
        return false;
    }

    public int trapRainWater(int[][] heightMap) {
        // get Max
        int m = heightMap.length;
        int n = heightMap[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, heightMap[i][j]);
            }
        }

        int res = 0;
        int next = max + 1;
        for (int h = 1; h <= max; h = next) {
            next = max + 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (heightMap[i][j] > h) {
                        next = Math.min(next, heightMap[i][j]);
                    } else if (heightMap[i][j] != -1 && heightMap[i][j] < h) {
                        if (border(heightMap, i, j)) continue;
                        // dfs
                        Deque<int[]> posStack = new ArrayDeque<>();
                        List<int[]> record = new ArrayList<>();
                        int[] first = new int[]{i, j};
                        posStack.addLast(first);
                        record.add(first);
                        int count = h - heightMap[i][j];
                        heightMap[i][j] = h;
                        boolean leak = false;
                        while (!posStack.isEmpty()) {
                            int[] pos = posStack.pollLast();
                            for (int k = 0; k < 4; k++) {
                                int row = pos[0] + d[k][0];
                                int col = pos[1] + d[k][1];
                                if (outside(heightMap, row, col)) {
                                    leak = true;
                                } else if (heightMap[row][col] != -1 && heightMap[row][col] < h) {
                                    int[] newPos = new int[]{row, col};
                                    posStack.addLast(newPos);
                                    record.add(newPos);
                                    count += h - heightMap[row][col];
                                    heightMap[row][col] = h;
                                }
                            }
                        }
                        if (leak) {
                            for (int[] pos : record) {
                                heightMap[pos[0]][pos[1]] = -1;
                            }
                        } else {
                            res += count;
                        }
                    }
                }
            }            
        }
        return res;
    }
}

// layers to analyze
// dfs


// better solution
class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visit = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[]{i * n + j, heightMap[i][j]});
                    visit[i][j] = true;
                }
            }
        }
        int res = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            for (int k = 0; k < 4; ++k) {
                int nx = curr[0] / n + dirs[k];
                int ny = curr[0] % n + dirs[k + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny]) {
                    if (curr[1] > heightMap[nx][ny]) {
                        res += curr[1] - heightMap[nx][ny];
                    }
                    pq.offer(new int[]{nx * n + ny, Math.max(heightMap[nx][ny], curr[1])});
                    visit[nx][ny] = true;
                }
            }
        }
        return res;
    }
}

