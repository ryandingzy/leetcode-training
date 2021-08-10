class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int heigh = prices[prices.length - 1];
        int max = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] < heigh) {
                max = Math.max(heigh - prices[i], max);
            } else {
                heigh = prices[i];
            }
        }
        return max;
    }
}
