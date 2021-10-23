class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int res = 1;
        for (int i = n; i >= 1; i--) {
            res += 9 * calA(9, i - 1);
        }
        return res;
    }
    
    private int calA(int n, int j) {
        int res = 1;
        for (int i = 0; i < j; i++) {
            res *= n - i;
        }
        return res;
    }
}
