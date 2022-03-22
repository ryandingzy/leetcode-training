class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        
        int len = Math.max(len1, len2) + 1;
        int[] sum = new int[len];
        for (int i = 0; i < len1; i++) {
            sum[len - 1 - i] = num1.charAt(len1 - 1 - i) - '0';
        }
        for (int i = 0; i < len2; i++) {
            sum[len - 1 - i] += num2.charAt(len2 - 1 - i) - '0';
        }
        for (int i = len - 1; i >= 0; i--) {
            if (sum[i] >= 10) {
                sum[i-1] += 1;
                sum[i] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (0 != sum[0]) {
            sb.append((char)(sum[0] + '0'));
        }
        for (int i = 1; i < len; i++) {
            sb.append((char)(sum[i] + '0'));
        }
        return sb.toString();
    }
}
