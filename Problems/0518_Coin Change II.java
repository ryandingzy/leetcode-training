class Solution {
    HashMap<String, Integer> map;

    private int dfs(int[] coins, int start, int amount) {
        String key = start + "-" + amount;
        if (map.containsKey(key)) return map.get(key);

        int n = coins.length;
        if (amount <= 0) {
            return 1;
        }
        if (start >= n) {
            return 0;
        }
        int res = 0;
        for (int i = start; i < n; i++) {
            if (coins[i] > amount) {
                continue;
            }
            res += dfs(coins, i, amount - coins[i]);
        }

        map.put(key, res);

        return res;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int tmp = coins[l];
            coins[l] = coins[r];
            coins[r] = tmp;
            l++;
            r--;
        }

        map = new HashMap<>();
        
        return dfs(coins, 0, amount);
    }
}

// Better solution -- Dynamic programming

class Solution {
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) {
      for (int x = coin; x < amount + 1; ++x) {
        dp[x] += dp[x - coin];
      }
    }
    return dp[amount];
  }
}
