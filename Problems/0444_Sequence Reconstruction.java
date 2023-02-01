class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        List<Set<Integer>> nextList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            nextList.add(new HashSet<Integer>());
        }
        int[] degree = new int[n + 1];
        for (List<Integer> seq : sequences) {
            for (int i = 1; i < seq.size(); i++) {
                int from = seq.get(i-1);
                int to = seq.get(i);
                if (nextList.get(from).contains(to)) continue;
                nextList.get(from).add(to);
                degree[to]++;
            }
        }
        int node = -1;
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                if (node != -1) return false;
                else node = i;
            }
        }
        int id = 0;
        while (node != -1) {
            int cur = node;
            node = -1;
            if (cur != nums[id]) return false;
            id++;
            for (int next : nextList.get(cur)) {
                degree[next]--;
                if (degree[next] == 0) {
                    if (node != -1) return false;
                    node = next;
                }
            }
        }
        return id == n;
    }
}
