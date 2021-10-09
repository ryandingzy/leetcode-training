class Solution {
    public int numWays(int n, int k) {
        int n1 = 1;
        int n2 = 2;
        int next = n1 + n2;
        int res1 = k;
        int res2 = k + k * (k - 1);
        int res = (res1 + res2) * (k - 1);
        if (n == 1) return res1;
        if (n == 2) return res2;
        n = n - 3;
        while (n > 0) {
            n1 = n2;
            n2 = next;
            next = n1 + n2;
            res1 = res2;
            res2 = res;
            res = (res1 + res2) * (k - 1);
            n--;
        }
        return res;
    }
}
