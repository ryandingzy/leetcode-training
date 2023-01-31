class Solution {
    public int arrangeCoins(int n) {
        long r = 100000;
        long l = 0;
        while (l + 1 < r) {
            long m = (r + l) >> 1;
            long count = (m * (m + 1)) >> 1;
            if (count < n) {
                l = m;
            } else if (count == n) {
                return (int)m;
            } else {
                r = m - 1;
            }
        }
        if ((r * (r + 1)) >> 1 <= n) return (int)r;
        return (int)l;
    }
}
