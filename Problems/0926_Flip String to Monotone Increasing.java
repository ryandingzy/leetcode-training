class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int idx = -1;
        int min = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count--;
            } else {
                count++;
            }
            if (count <= min) {
                idx = i;
                min = count;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i <= idx && s.charAt(i) == '1') {
                res++;
            } else if (i > idx && s.charAt(i) == '0') {
                res++;
            }
        }
        return res;
    }
}
