class Solution {
    public int myAtoi(String s) {
        int res = 0;
        boolean nonNegative = true;
        int idx = 0;
        // whitespace
        while (idx < s.length()) {
            if (s.charAt(idx) == ' ')
                idx++;
            else
                break;
        }
        // sign
        if (idx < s.length()) {
            if (s.charAt(idx) == '-') {
                idx++;
                nonNegative = false;
            } else if (s.charAt(idx) == '+') {
                idx++;
            }
        }
        
        // number
        while (idx < s.length()) {
            if (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                int num = s.charAt(idx) - '0';
                if (nonNegative) {
                    if (res <= (Integer.MAX_VALUE - (double)num) / 10) {
                        res = res * 10 + num;
                        idx++;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    if (res >= (Integer.MIN_VALUE + (double)num) / 10) {
                        res = res * 10 - num;
                        idx++;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                break;
            }
        }
        
        return res;
    }
}


/*
注意：
- idx一定要时刻注意不要超范围
- 翻译数字的时候，因为正负数的范围不同，不能统一用正数格式进行判断，最好带着本身符号进行一些列运算
*/