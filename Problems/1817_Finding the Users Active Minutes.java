class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] each : logs) {
            if (!map.containsKey(each[0]))
                map.put(each[0], new HashSet<Integer>());
            map.get(each[0]).add(each[1]);
        }
        for (Set<Integer> each : map.values()) {
            res[each.size() - 1]++;
        }
        return res;
    }
}
