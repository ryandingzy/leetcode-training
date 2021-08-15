class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.addLast(stack.pollLast() + stack.pollLast());
            } else if (tokens[i].equals("-")) {
                int tmp = stack.pollLast();
                stack.addLast(stack.pollLast() - tmp);
            } else if (tokens[i].equals("*")) {
                stack.addLast(stack.pollLast() * stack.pollLast());
            } else if (tokens[i].equals("/")) {
                int tmp = stack.pollLast();
                stack.addLast(stack.pollLast() / tmp);
            } else {
                int num = 0;
                String str = tokens[i];
                boolean negative = false;
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == '+') {
                        continue;
                    } else if (str.charAt(j) == '-') {
                        negative = true;
                    } else {
                        num = num * 10 + (str.charAt(j) - '0');
                    }
                }
                stack.addLast(negative ? 0 - num : num);
            }
        }
        return stack.pollLast();
    }
}
