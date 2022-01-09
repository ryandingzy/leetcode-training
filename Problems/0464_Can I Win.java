class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 一次带走
        if(maxChoosableInteger >= desiredTotal) return true;
        // 永远无法达到
        if((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false; 

        return dfs(0, desiredTotal, new Boolean[1 << maxChoosableInteger], maxChoosableInteger);
    }

    private boolean dfs(int state, int desiredTotal, Boolean[] dp, int maxChoosableInteger){
        if(dp[state] != null){
            return dp[state];
        }

        for(int i = 1; i <= maxChoosableInteger; i++){
            int cur = 1 << (i - 1);
            if((cur & state) != 0){
                continue;
            }

            if(i >= desiredTotal || !dfs(cur|state, desiredTotal - i, dp, maxChoosableInteger)){
                return dp[state] = true;
            }
        }
        return dp[state] = false;
    }
}

// dfs
