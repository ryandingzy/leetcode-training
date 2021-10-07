class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) return n == 1;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (map.containsKey(edges[i][0])) {
                map.get(edges[i][0]).add(edges[i][1]);
            } else {
                HashSet<Integer> tmp = new HashSet<Integer>();
                tmp.add(edges[i][1]);
                map.put(edges[i][0], tmp);
                
            }
            if (map.containsKey(edges[i][1])) {
                map.get(edges[i][1]).add(edges[i][0]);
            } else {
                HashSet<Integer> tmp = new HashSet<Integer>();
                tmp.add(edges[i][0]);
                map.put(edges[i][1], tmp);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(edges[0][0]);
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (!map.containsKey(cur)) return false;
            count++;
            for (int next : map.get(cur)) {
                map.get(next).remove(cur);
                queue.offer(next);
            }
            map.remove(cur);
        }
        return count == n;
    }
}
