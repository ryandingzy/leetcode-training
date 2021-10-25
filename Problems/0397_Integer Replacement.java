class Solution {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        
        int res = 0;
        
        while (true) {
            if (n == 1) return res;
            
            if ((n & 1) == 0) {
                n >>= 1;
                res++;
            } else if (n == 3 || (n & 2) == 0) {
                n -= 1;
                n >>= 1;
                res += 2;
            } else {
                n += 1;
                res += 1;
            }
        }
    }
}
