class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean odd = false;
        int res = 0;
        for (int c : count.values()) {
            if (c % 2 == 1) {
                odd = true;
            }
            res += c / 2 * 2;
        }
        if (odd) res += 1;
        return res;
    }
}
