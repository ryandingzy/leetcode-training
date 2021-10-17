class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        Deque<Character> stack = new ArrayDeque<>();
        stack.addLast(s.charAt(0));
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        map.put(s.charAt(0), map.get(s.charAt(0)) - 1);
        for (int i = 1; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                continue;
            }
            while (!stack.isEmpty() && stack.peekLast() > s.charAt(i)) {
                if (map.get(stack.peekLast()) == 0) break;
                else {
                    set.remove(stack.peekLast());
                    stack.pollLast();
                }
            }
            stack.addLast(s.charAt(i));
            set.add(s.charAt(i));
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
