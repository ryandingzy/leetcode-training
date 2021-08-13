class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // init the set
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        
        // dp
        List<String>[] dp = new List[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i + 1);
            if (set.contains(str)) {
                dp[i].add(str);
            }
            for (int j = i; j > 0; j--) {
                if (dp[j-1].isEmpty()) continue;
                str = s.substring(j, i + 1);
                if (set.contains(str)) {
                    for (String substr : dp[j-1]) {
                        dp[i].add(substr + ' ' + str);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}
