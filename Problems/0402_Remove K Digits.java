class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (n == 1) return "0";

        String[] cur = new String[n];
        String[] pre;

        cur[0] = num.substring(1);
        
        for (int i = 1; i < n; i++) {
            String s1 = cur[i - 1];
            String s2 = num.substring(0, i) + num.substring(i + 1);
            cur[i] = s1.compareTo(s2) < 0 ? s1 : s2;
        }
        
        for (int i = 1; i < k; i++) {
            pre = cur;
            cur = new String[n];
            
            for (int j = i; j < n; j++) {
                if (j == i) {
                    cur[j] = num.substring(i + 1);
                    continue;
                }
                String s1 = cur[j - 1];
                String s2 = pre[j - 1].substring(0, j - i) + num.substring(j + 1);
                cur[j] = s1.compareTo(s2) < 0 ? s1 : s2;
            }
        }
        if (cur[n - 1].isEmpty())
            return "0";
        return Integer.toString(Integer.valueOf(cur[n - 1]));
        
    }
}

// greedy stack
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > num.charAt(i)) {
                stack.pollLast();
                k--;
            }
            stack.addLast(num.charAt(i));
        }
        
        while (k > 0 && !stack.isEmpty()) {
            stack.pollLast();
            k--;
        }
        
        while (!stack.isEmpty() && stack.peekFirst() == '0') {
            stack.pollFirst();
        }
        if (stack.isEmpty())
            return "0";
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}

