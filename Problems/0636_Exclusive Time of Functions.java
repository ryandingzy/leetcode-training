class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        int lastT = 0;
        boolean justEnd = false;
        int size = logs.size();
        for (int i = 0; i < size; i++) {
            String[] strs = logs.get(i).split(":");
            int id = Integer.valueOf(strs[0]);
            int t = Integer.valueOf(strs[2]);
            if (strs[1].equals("start")) {
                // start
                if (!stack.isEmpty()) {
                    if (justEnd) {
                        time[stack.peekLast()] += t - lastT - 1;
                    } else {
                        time[stack.peekLast()] += t - lastT;
                    }
                }
                stack.addLast(id);
                justEnd = false;
            } else {
                // end
                if (justEnd) {
                    time[id] += t - lastT;
                } else {
                    time[id] += t - lastT + 1;
                }
                stack.pollLast();
                justEnd = true;
            }
            lastT = t;
        }
        return time;
    }
}
