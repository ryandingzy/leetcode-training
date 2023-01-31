class Solution {
    public int findKthNumber(int n, int k) {
        long cur = 1;
        k -= 1;

        while (k > 0) {
            int nodes = countNodes(n, cur);
            if (k >= nodes) {
                k -= nodes;
                cur++;
            } else {
                k--;
                cur *= 10;
            }
        }
        return (int) cur;
    }

    private int countNodes(long n, long cur) {
        long total = 0;
        long next = cur + 1;
        while (cur <= n) {
            total += Math.min(n - cur + 1, next - cur);
            cur *= 10;
            next *= 10;
        }
        return (int) total;
    }
}
