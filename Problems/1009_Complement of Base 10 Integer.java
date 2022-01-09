class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        // return (Integer.highestOneBit(n) << 1) - n - 1;
        
        
        int res = 0;
        int i = 0;
        while (n != 0) {
            res |= (1 - (n & 1)) << i;
            n >>= 1;
            i++;
        }
        return res;
    }
}
