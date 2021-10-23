class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        return binarySearch(num, 1, num / 2);
    }
    
    private boolean binarySearch(int num, int left, int right) {
        if (left > right) return false;
        
        int mid = (right - left) / 2 + left;
        long value = (long)mid * mid;
        
        if (value == num) return true;
        else if (num < value) return binarySearch(num, left, mid - 1);
        else return binarySearch(num, mid + 1, right);
    }
}
