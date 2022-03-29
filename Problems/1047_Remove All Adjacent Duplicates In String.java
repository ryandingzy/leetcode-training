class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (!stack.isEmpty() && stack.peekLast() == s.charAt(i)) {
                stack.pollLast();
            } else {
                stack.addLast(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.reverse().toString();
    }
}
