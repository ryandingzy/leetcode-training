class Solution {
    public int numDecodings(String s) {
        int[] ways = new int[s.length()];
        int i;
        if (s.length() == 1) return s.equals("0") ? 0 : 1;
        // Init
        if (s.charAt(s.length() - 1) == '0') {
            if (s.charAt(s.length() - 2) == '0') return 0;
            if (s.charAt(s.length() - 2) - '0' > 2) return 0;
            else {
                ways[s.length() - 1] = 0;
                ways[s.length() - 2] = 1;
                i = s.length() - 3;
            }
        } else {
            ways[s.length() - 1] = 1;
            i = s.length() - 2;
        }
        
        // dynamic programming
        for (; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                if (i - 1 < 0 || s.charAt(i - 1) == '0' || s.charAt(i - 1) - '0' > 2) return 0;
                else {
                    ways[i] = 0;
                    ways[i-1] = ways[i+1];
                    i--;
                }
            } else {
                if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    if (i + 2 > s.length() - 1) ways[i] = 2;
                    else ways[i] = ways[i+1] + ways[i+2];
                } else {
                    ways[i] = ways[i+1];
                }
            }
        }
        return ways[0];
    }
}
