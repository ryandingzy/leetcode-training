class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        if (n == 0) return res;
        res[1] = 1;
        if (n == 1) return res;
        
        int i1 = 1;
        int i2 = 1;
        for (int i = 2; i <= n; i++) {
            if (i == i2 << 1) {
                res[i] = res[i2];
                i2++;
            } else {
                res[i] = res[i1] + 1;
                i1++;
            }
        }
        return res;        
    }
}
