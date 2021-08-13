// my solution, is not fast enough
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }
        return dfs(s, 0, set);
    }
    public boolean dfs(String s, int start, Set<String> set) {
        for (int i = start; i < s.length(); i++) {
            String substr = s.substring(start, i + 1);
            if (set.contains(substr)) {
                if (i == s.length() - 1 || dfs(s, i + 1, set)) return true;
            }
        }
        return false;
    }
}

// better solution, dynamic programming
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.substring(0, i + 1))) {
                dp[i] = true;
            } else {
                int j = i;
                for (; j > 0; j--) {
                    if (dp[j-1] && set.contains(s.substring(j, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                }
                if (j == 0) dp[i] = false;
            }
        }
        return dp[s.length() - 1];
    }
}
