class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] res = new int[n];
        
        if (a == 0) {
            for (int i = 0; i < n; i++) {
                res[i] = cal(nums[i], a, b, c);
            }
            if (b < 0) reverseNum(res); 
            return res;
        }
        
        double mid = 0 - b / ((double)a * 2);
        int first = binarySearch(nums, 0, n - 1, mid);
        res[0] = cal(nums[first], a, b, c);
        int left = first - 1;
        int right = first + 1;
        int index = 1;
        while (index < n) {
            int numL = 1000;
            if (left >= 0) numL = nums[left];
            int numR = 1000;
            if (right < n) numR = nums[right];
            if (Math.abs(numL - mid) < Math.abs(numR - mid)) {
                res[index++] = cal(numL, a, b, c);
                left--;
            } else {
                res[index++] = cal(numR, a, b, c);
                right++;
            }
        }
        if (a < 0) {
            reverseNum(res);
        }
        
        return res;
    }
    
    private void reverseNum(int[] res) {
        int l = 0, r = res.length - 1;
        while (l < r) {
            int tmp = res[l];
            res[l] = res[r];
            res[r] = tmp;
            l++;
            r--;
        }
    }
    
    private int binarySearch(int[] nums, int left, int right, double target) {
        if (left >= right - 1) {
            return Math.abs(nums[left] - target) < Math.abs(nums[right] - target) ? left : right;
        }
        
        int mid = (left + right) / 2;
        if (target == nums[mid]) return mid;
        if (target > nums[mid]) return binarySearch(nums, mid, right, target);
        return binarySearch(nums, left, mid, target);
    }
    
    private int cal(int num, int a, int b, int c) {
        return a * num * num + b * num + c;
    }
}
