class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m-1][n-1])
            return false;
        return binarySearch(matrix, 0, m * n - 1, target);
    }
    
    public boolean binarySearch(int[][] matrix, int low, int high, int target) {
        if (low > high)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int mid = (low + high) / 2;
        if (matrix[mid / n][(mid % n)] == target)
            return true;
        else if (matrix[mid / n][(mid % n)] > target)
            return binarySearch(matrix, low, mid - 1, target);
        else
            return binarySearch(matrix, mid + 1, high, target);
    }
}
