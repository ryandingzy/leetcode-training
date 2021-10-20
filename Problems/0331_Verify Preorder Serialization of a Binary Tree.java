class Solution {
    public boolean isValidSerialization(String preorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        String[] strs = preorder.split(",");
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("#")) {
                while (!stack.isEmpty() && stack.peekLast() == 0) {
                    stack.pollLast();
                    if (stack.isEmpty()) return false;
                    stack.pollLast();
                }
                stack.addLast(0);
            } else {
                stack.addLast(1);
            }
        }
        if (stack.pollLast() != 0) return false;
        return stack.isEmpty();
    }
}
