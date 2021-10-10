class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        List<int[]> pos = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    pos.add(new int[]{i, j});
                }
            }
        }
        Collections.sort(pos, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int row = pos.get(pos.size() / 2)[0];
        
        Collections.sort(pos, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int col = pos.get(pos.size() / 2)[1];
        
        int distance = 0;
        for (int[] friend : pos) {
            distance += Math.abs(friend[0] - row);
            distance += Math.abs(friend[1] - col);
        }
        return distance;
    }
}

// better solution
class Solution {
    private List<Integer> collectRows(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                }
            }
        }
        return rows;
    }

    private List<Integer> collectCols(int[][] grid) {
        List<Integer> cols = new ArrayList<>();
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == 1) {
                    cols.add(col);
                }
            }
        }
        return cols;
    }
    
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = collectRows(grid);
        List<Integer> cols = collectCols(grid);
        return minDistance1D(rows) + minDistance1D(cols);
    }

    private int minDistance1D(List<Integer> points) {
        int distance = 0;
        int i = 0;
        int j = points.size() - 1;
        while (i < j) {
            distance += points.get(j) - points.get(i);
            i++;
            j--;
        }
        return distance;
    }
}
