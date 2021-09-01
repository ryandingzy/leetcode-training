class Solution {
    List<List<Integer>> edges;
    int[] indeg;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) queue.offer(i);
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            res[visited] = u;
            visited++;
            for (int v : edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) queue.offer(v);
            }
        }
        return visited == numCourses ? res : new int[0];
    }
}
