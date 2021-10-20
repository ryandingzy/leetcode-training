class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int l = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while (map.size() > k) {
                char tail = s.charAt(l);
                if (map.get(tail) == 1) map.remove(tail);
                else map.put(tail, map.get(tail) - 1);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
