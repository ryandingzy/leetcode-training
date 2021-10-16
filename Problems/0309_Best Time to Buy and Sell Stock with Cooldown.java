class Solution {
  public int maxProfit(int[] prices) {
      int rest = 0;
      int sold = 0;
      int hold = Integer.MIN_VALUE;
      for (int i = 0; i < prices.length; i++) {
          int newhold = Math.max(hold, rest - prices[i]);
          int newSold = hold + prices[i];
          int newRest = Math.max(rest, sold);
          hold = newhold;
          sold = newSold;
          rest = newRest;
      }
      return Math.max(sold, rest);
  }
}
