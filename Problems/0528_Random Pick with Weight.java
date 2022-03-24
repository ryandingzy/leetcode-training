class Solution {
    int bound;
    //int[] weight;
    int[] sum;
    
    public Solution(int[] w) {
        //weight = w;
        int len = w.length;
        sum = new int[len];
        for (int i = 0; i < len; i++) {
            bound += w[i];
            sum[i] = bound;
        }
    }
    
    public int pickIndex() {
        Random rand = new Random();
        int num = rand.nextInt(bound) + 1; // 这里需要+1，使得概率范围是1---bound
        return binarySearch(num, 0, sum.length - 1);
    }
    
    private int binarySearch(int num, int l, int r) {
        if (l == r) return l;
        int mid = (l + r) / 2;
        if (num <= sum[mid]) {
            return binarySearch(num, l, mid);
        } else {
            return binarySearch(num, mid + 1, r);
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
