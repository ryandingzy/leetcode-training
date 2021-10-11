class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int len1 = 1; len1 <= num.length() - 2 && len1 <= num.length() / 2; len1++) {
            if (num.charAt(0) == '0' && len1 > 1) break;
            for (int len2 = 1; len2 + len1 <= num.length() - 1 && len2 <= num.length() / 2; len2++) {
                if (num.charAt(len1) == '0' && len2 > 1) break;
                if (judge(num, 0, len1, len2)) return true;
            }
        }
        return false;
    }
    
    public boolean judge(String num, int start, int len1, int len2) {
        long num1 = Long.valueOf(num.substring(start, start + len1));
        long num2 = Long.valueOf(num.substring(start + len1, start + len1 + len2));
        String sum = Long.toString(num1 + num2);
        if (num.substring(start + len1 + len2).startsWith(sum)) {
            if (start + len1 + len2 + sum.length() == num.length()) return true;
            return judge(num, start + len1, len2, sum.length());
        }
        return false;
    }
}
