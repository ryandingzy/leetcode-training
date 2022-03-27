class Solution {
    public boolean validPalindrome(String s) {
        return valid(s, 0, s.length() - 1, 1);
    }
    
    private boolean valid(String s, int l, int r, int count) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (count != 0) {
                    if (valid(s, l + 1, r, count - 1)) return true;
                    if (valid(s, l, r - 1, count - 1)) return true;
                }
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
