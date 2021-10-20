class Solution {
    public int integerBreak(int n) {
        int res = 1;
        for (int k = 2; k <= n - 1; k++) {
            int product = 1;
            for (int i = 0; i < k; i++) {
                if (i < n - n / k * k) {
                    product *= n / k + 1;
                } else {
                    product *= n / k;
                }
            }
            res = Math.max(res, product);
        }
        return res;
    }
}
