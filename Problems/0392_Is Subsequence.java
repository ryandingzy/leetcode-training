class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        int is = 0;
        int it = 0;
        while (it < t.length()) {
            if (s.charAt(is) == t.charAt(it)) {
                is++;
            }
            if (is == s.length()) return true;
            it++;
        }
        return false;
    }
}
