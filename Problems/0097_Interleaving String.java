// My Solution
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return dfs(s1, 0, s2, 0, s3, 0);
    }

    public boolean dfs(String s1, int i1, String s2, int i2, String s3, int i3) {
        if (i3 == s3.length()) {
            if (i1 == s1.length() && i2 == s2.length()) return true;
            else return false;
        }
        boolean res = false;
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
            res = res || dfs(s1, i1 + 1, s2, i2, s3, i3 + 1);
        }
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            res = res || dfs(s1, i1, s2, i2 + 1, s3, i3 + 1);
        }
        return res;
    }
}

// dynamic programming
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];
    }
}

// 滚动数组优化dp表
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];
    }
}
