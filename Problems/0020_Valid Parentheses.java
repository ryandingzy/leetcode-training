class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.addLast(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.pollLast() != '(') return false;
            } else if (s.charAt(i) == '}') {
                if (stack.isEmpty() || stack.pollLast() != '{') return false;
            } else if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.pollLast() != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
