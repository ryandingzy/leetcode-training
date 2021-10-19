class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        
        return mergeSort(sum, 0, n, lower, upper);
    }
    
    private int mergeSort(long[] sum, int lo, int hi, int lower, int upper) {
        if (lo >= hi) return 0;
        int mid = (hi + 1 - lo) / 2 + lo;
        
        int count = mergeSort(sum, lo, mid - 1, lower, upper) + 
            mergeSort(sum, mid, hi, lower, upper);
        
        int startIndex = mid, endIndex = mid;
        for (int i = lo; i < mid; i++) {
            while (startIndex <= hi && sum[startIndex] - sum[i] < lower) {
                startIndex++;
            }
            
            while (endIndex <= hi && sum[endIndex] - sum[i] <= upper) {
                endIndex++;
            }
            
            count += endIndex - startIndex;
        }
        
        merge(sum, lo, mid - 1, mid, hi);
        return count;
    }
    
    private void merge(long[] sum, int lo1, int hi1, int lo2, int hi2) {
        long[] helper = new long[hi2 - lo1 + 1];
        int index = 0;
        int index1 = lo1, index2 = lo2;
        
        while (index1 <= hi1 && index2 <= hi2) {
            if (sum[index1] <= sum[index2]) {
                helper[index++] = sum[index1++];
            } else {
                helper[index++] = sum[index2++];
            }
        }
        
        while (index1 <= hi1) {
            helper[index++] = sum[index1++];
        }
        
        while (index2 <= hi2) {
            helper[index++] = sum[index2++];
        }
        
        System.arraycopy(helper, 0, sum, lo1, hi2 - lo1 + 1);
    }
}
