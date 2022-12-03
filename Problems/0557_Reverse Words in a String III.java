class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        int p = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                int j = i - 1;
                while (j >= p) {
                    sb.append(s.charAt(j));
                    j--;
                }
                sb.append(' ');
                p = i + 1;
            }
        }
        int j = n - 1;
        while (j >= p) {
            sb.append(s.charAt(j));
            j--;
        }
        return sb.toString();
    }
}
