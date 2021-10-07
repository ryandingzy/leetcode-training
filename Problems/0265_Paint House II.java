class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        for (int i = 1; i < n; i++) {
            int min; int minId;
            int sec;
            if (costs[i-1][0] < costs[i-1][1]) {
                min = costs[i-1][0]; minId = 0;
                sec = costs[i-1][1];
            } else {
                min = costs[i-1][1]; minId = 1;
                sec = costs[i-1][0];
            }
            for (int j = 2; j < k; j++) {
                if (costs[i-1][j] < min) {
                    sec = min;
                    min = costs[i-1][j];
                    minId = j;
                } else if (costs[i-1][j] < sec) {
                    sec = costs[i-1][j];
                }
            }
            for (int j = 0; j < k; j++) {
                if (j == minId) {
                    costs[i][j] += sec;
                } else {
                    costs[i][j] += min;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            res = Math.min(res, costs[n-1][j]);
        }
        return res;
    }
}
