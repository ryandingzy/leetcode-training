class Solution {
    public String parseTernary(String expression) {
        int n = expression.length();
        if (n == 1) {
            return expression;
        }
        
        int count = 0;
        for (int i = 2; i < n; i++) {
            char c = expression.charAt(i);
            if (c == '?') count++;
            else if (c == ':') {
                if (count == 0) {
                    if (expression.charAt(0) == 'T') {
                        return parseTernary(expression.substring(2, i));
                    } else {
                        return parseTernary(expression.substring(i + 1, n));
                    }
                } else {
                    count--;
                }
            }
        }
        return "";
    }
}
