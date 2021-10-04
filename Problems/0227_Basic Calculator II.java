class Solution {
    public int calculate(String s) {
        int res = 0;
        int operation = 1;
        int num = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '+') {
                res = res + operation * num;
                operation = 1;
                num = 0;
                i++;
            } else if (s.charAt(i) == '-') {
                res = res + operation * num;
                operation = -1;
                num = 0;
                i++;
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                int tmp = 0;
                int j = i + 1;
                while (s.charAt(j) == ' ') j++;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    tmp = tmp * 10 + s.charAt(j) - '0';
                    j++;
                }
                if (s.charAt(i) == '*') num *= tmp;
                else num /= tmp;
                i = j;
            } else if (Character.isDigit(s.charAt(i))){
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            } else {
                i++;
            }
        }
        return res + operation * num;
    }
}
