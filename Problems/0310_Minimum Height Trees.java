// My solution -- TLE
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            int height = 0;
            int bound  = 1;
            int count = 0;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                set.add(cur);
                for (int next : map.get(cur)) {
                    if (set.contains(next)) continue;
                    queue.offer(next);
                    count++;
                }
                bound--;
                if (bound == 0) {
                    height++;
                    bound = count;
                    count = 0;
                }
            }
            if (height < min) {
                res.clear();
                res.add(i);
                min = height;
            } else if (height == min) {
                res.add(i);
            }
        }
        return res;
    }
}

// Better solution
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // base cases
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }

        // Build the graph with the adjacency list
        ArrayList<Set<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++)
            neighbors.add(new HashSet<Integer>());

        for (int[] edge : edges) {
            Integer start = edge[0], end = edge[1];
            neighbors.get(start).add(end);
            neighbors.get(end).add(start);
        }

        // Initialize the first layer of leaves
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (neighbors.get(i).size() == 1)
                leaves.add(i);

        // Trim the leaves until reaching the centroids
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();

            // remove the current leaves along with the edges
            for (Integer leaf : leaves) {
                // the only neighbor left for the leaf node
                Integer neighbor = neighbors.get(leaf).iterator().next();
                // remove the edge along with the leaf node
                neighbors.get(neighbor).remove(leaf);
                if (neighbors.get(neighbor).size() == 1)
                    newLeaves.add(neighbor);
            }

            // prepare for the next round
            leaves = newLeaves;
        }

        // The remaining nodes are the centroids of the graph
        return leaves;
    }
}
