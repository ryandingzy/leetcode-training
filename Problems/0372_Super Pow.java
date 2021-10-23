class Solution {
    int base = 1337;
    
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length - 1);
    }
    
    private int superPow(int a, int[] b, int last) {
        if (last == -1) return 1;
        
        int part1 = myPow(a, b[last]);
        int part2 = myPow(superPow(a, b, last - 1), 10);
        return (part1 * part2) % base;
    }
    
    // 计算a的k次方，然后与base求模的结果
    private int myPow(int a, int k) {
        if (k == 0) return 1;
        
        a %= base;
        int res = 1;
        
        if (k % 2 == 1) {
            return (a * myPow(a, k - 1)) % base;
        } else {
            int sub = myPow(a, k / 2);
            return (sub * sub) % base;
        }
    }
}
