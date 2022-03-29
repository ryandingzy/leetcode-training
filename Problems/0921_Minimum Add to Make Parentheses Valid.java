class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0;
        int count = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    res++;
                }
            }
        }
        return res + count;
    }
}
