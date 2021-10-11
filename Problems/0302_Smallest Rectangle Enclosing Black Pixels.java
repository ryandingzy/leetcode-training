// DFS
public class Solution {
    private int top, bottom, left, right;
    public int minArea(char[][] image, int x, int y) {
        if(image.length == 0 || image[0].length == 0) return 0;
        top = bottom = x;
        left = right = y;
        dfs(image, x, y);
        return (right - left) * (bottom - top);
    }
    private void dfs(char[][] image, int x, int y){
        if(x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] == '0')
            return;
        image[x][y] = '0'; // mark visited black pixel as white
        top = Math.min(top, x);
        bottom = Math.max(bottom, x + 1);
        left = Math.min(left, y);
        right = Math.max(right, y + 1);
        dfs(image, x + 1, y);
        dfs(image, x - 1, y);
        dfs(image, x, y - 1);
        dfs(image, x, y + 1);
    }
}

// binary search
public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int left = searchColumns(image, 0, y, 0, m, true);
        int right = searchColumns(image, y + 1, n, 0, m, false);
        int top = searchRows(image, 0, x, left, right, true);
        int bottom = searchRows(image, x + 1, m, left, right, false);
        return (right - left) * (bottom - top);
    }
    private int searchColumns(char[][] image, int i, int j, int top, int bottom, boolean whiteToBlack) {
        while (i != j) {
            int k = top, mid = (i + j) / 2;
            while (k < bottom && image[k][mid] == '0') ++k;
            if (k < bottom == whiteToBlack) // k < bottom means the column mid has black pixel
                j = mid; //search the boundary in the smaller half
            else
                i = mid + 1; //search the boundary in the greater half
        }
        return i;
    }
    private int searchRows(char[][] image, int i, int j, int left, int right, boolean whiteToBlack) {
        while (i != j) {
            int k = left, mid = (i + j) / 2;
            while (k < right && image[mid][k] == '0') ++k;
            if (k < right == whiteToBlack) // k < right means the row mid has black pixel
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }
}
