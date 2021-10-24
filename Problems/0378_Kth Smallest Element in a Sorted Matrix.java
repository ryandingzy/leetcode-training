class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        return binarySearch(matrix, matrix[0][0], matrix[m-1][n-1], k);
    }
    
    public int binarySearch(int[][] matrix, int low, int heigh, int k) {
        if (low >= heigh) return low;
        
        int mid = low + (heigh - low) / 2;
        int count = countLowerOrEqual(matrix, mid);
        if (count < k)
            return binarySearch(matrix, mid + 1, heigh, k);
        else
            return binarySearch(matrix, low, mid, k);
    }
    
    public int countLowerOrEqual(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int res = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            while (row >= 0 && matrix[row][col] > target) row--;
            res += row + 1;
        }
        return res;
    }
}
