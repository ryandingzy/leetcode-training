class Solution {
    public boolean repeatedSubstringPattern(String s) {
        List<Character> sub = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            sub.add(s.charAt(i));
            int k = 0;
            boolean error = false;
            int size = sub.size();
            for (int j = i + 1; j < n; j++) {
                if (sub.get(k) != s.charAt(j)) {
                    error = true;
                    break;
                }
                k = (k + 1) % size;
            }
            if (!error && k == 0) return true;
        }
        return false;
    }
}
