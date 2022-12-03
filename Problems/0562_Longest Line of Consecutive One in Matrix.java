class Solution {
    private int getLen(int[][] mat, int r0, int c0, int rInc, int cInc) {
        int m = mat.length;
        int n = mat[0].length;
        int r = r0;
        int c = c0;
        int res = 0;
        int count = 0;
        while (r < m  && r >= 0 && c < n && c >= 0) {
            if (mat[r][c] == 1) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 0;
            }
            r += rInc;
            c += cInc;
        }
        return res;
    }
    public int longestLine(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, getLen(mat, i, 0, 0, 1));
            res = Math.max(res, getLen(mat, i, 0, 1, 1));
            res = Math.max(res, getLen(mat, i, 0, -1, 1));
        }
        for (int j = 0; j < n; j++) {
            res = Math.max(res, getLen(mat, 0, j, 1, 0));
            if (j > 0) {
                res = Math.max(res, getLen(mat, 0, j, 1, 1));
                res = Math.max(res, getLen(mat, m - 1, j, -1, 1));
            }
        }
        return res;
    }
}
