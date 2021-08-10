class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            while (l <= r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l <= r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if (l <= r && format(s.charAt(l)) != format(s.charAt(r))) return false;
            l++;
            r--;
        }
        return true;
    }
    
    public char format(char c) {
        return Character.isUpperCase(c) ? Character.toLowerCase(c) : c;
    }
}
