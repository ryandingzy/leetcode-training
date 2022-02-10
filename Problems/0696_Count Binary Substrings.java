class Solution {
    public int countBinarySubstrings(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        while (right + 1 < n && s.charAt(right + 1) == s.charAt(right)) {
            right++;
        }
        int count = 0;
        while (right < n - 1) {
            int next = right + 1;
            while (next + 1 < n && s.charAt(next + 1) == s.charAt(next)) {
                next++;
            }
            count += Math.min(right - left + 1, next - right);
            left = right + 1;
            right = next;
        }
        return count;
    }
}
