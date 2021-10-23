class Solution {
    int result = Integer.MIN_VALUE;
    void updateResult(int[] nums, int k) {
        int sum = 0;

        TreeSet<Integer> sortedSum = new TreeSet<>();

        sortedSum.add(0);
        for (int num : nums) {
            sum += num;

            // Get X where Running sum - X <= k such that sum - X is closest to k.
            Integer x = sortedSum.ceiling(sum - k);

            // If such X is found in the prefix sums.
            // Get the sum of that sub array and update the global maximum result.
            if (x != null)
                result = Math.max(result, sum - x);

            sortedSum.add(sum);
        }
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[] rowSum = new int[matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(rowSum, 0);
            for (int row = i; row < matrix.length; row++) {
                // 压缩到一维
                for (int col = 0; col < matrix[0].length; col++)
                    rowSum[col] += matrix[row][col];

                updateResult(rowSum, k);

                if (result == k)
                    return result;
            }
        }
        return result;
    }
}
