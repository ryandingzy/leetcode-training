class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int res = 0;
        int num = 0;
        int l = left;
        while (l != 0) {
            if ((l & 1) == 1 && (int)(right / Math.pow(2, num)) == (int)(left / Math.pow(2, num))) {
                res |= 1 << num;
            }
            l >>>= 1;
            num++;
        }
        return res;
    }
}


// common substring
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }
}
