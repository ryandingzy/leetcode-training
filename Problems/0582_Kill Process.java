class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        
        int n = pid.size();
        HashMap<Integer, List<Integer>> child = new HashMap<>();
        child.put(0, new ArrayList<Integer>());
        for (int i = 0; i < n; i++) {
            child.put(pid.get(i), new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            child.get(ppid.get(i)).add(pid.get(i));
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            List<Integer> next = child.get(node);
            for (int c : next) {
                queue.offer(c);
            }
        }
        return res;
    }
}
