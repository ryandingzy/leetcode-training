class Solution {
    public int trailingZeroes(int n) {
        int base = 5;
        int count = 0;
        while (n >= base) {
            count += n / base;
            base *= 5;
        }
        return count;
    }
}
