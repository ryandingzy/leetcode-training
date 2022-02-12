class Solution {
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        //boolean[] arr = new boolean[n + 1];
        int[] arr = new int[n + 1];
        int len = connections.length;
        int cost = 0;
        for (int i = 0; i < len; i++) {
            int node1 = connections[i][0];
            int node2 = connections[i][1];
            int weight = connections[i][2];
            int root1 = getRoot(node1, arr);
            int root2 = getRoot(node2, arr);
            if (root1 == root2) continue;
            arr[root2] = root1;
            cost += weight;
        }
        boolean root = false;
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                if (root) return -1;
                root = true;
            }
        }
        return cost;
    }
    
    private int getRoot(int n, int[] arr) {
        int cur = n;
        int pre = n;
        while (cur != 0) {
            pre = cur;
            cur = arr[cur];
        }
        return pre;
    }
}
