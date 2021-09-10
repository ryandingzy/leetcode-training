// Time Limit Exceeded
class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < n; i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        int mid = n - 1;
        for (mid = n - 1; mid >= 0; mid--) {
            boolean found = true;
            for (int j = 1; mid - j >= 0; j++) {
                if (sb.charAt(mid + j) != sb.charAt(mid - j)) {
                    found = false;
                    break;
                }
            }
            if (found) break;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 2 * n - 2; i >= mid; i--) {
            if (sb.charAt(i) != '#') res.append(sb.charAt(i));
        }
        for (int i = mid + 1; i <= 2 * n - 2; i++) {
            if (sb.charAt(i) != '#') res.append(sb.charAt(i));
        }
        return res.toString();
    }
}

// better solution
class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n <= 0) return s;
        int[] next = new int[n];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        // match
        j = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
        }
        String add = (j == n) ? "" : s.substring(j);
        StringBuilder ans = new StringBuilder(add).reverse();
        ans.append(s);
        return ans.toString();
    }
}
