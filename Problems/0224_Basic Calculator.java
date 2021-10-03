class Solution {
    public int calculate(String s) {
        int res = 0;
        int operation = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                stack.addLast(res);
                stack.addLast(operation);
                res = 0;
                operation = 1;
                i++;
            } else if (s.charAt(i) == ')') {
                int lastOper = stack.pollLast();
                int lastNum = stack.pollLast();
                res = lastNum + lastOper * res;
                i++;
            } else if (s.charAt(i) == '+') {
                operation = 1;
                i++;
            } else if (s.charAt(i) == '-') {
                operation = -1;
                i++;
            } else if (Character.isDigit(s.charAt(i))){
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res = res + operation * num;
            } else {
                i++;
            }
        }
        return res;
    }
}
