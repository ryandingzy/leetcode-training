class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        if (n <= 2) return 0;

        List<Map<Integer, Integer>> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lst.add(new HashMap<Integer, Integer>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xdiff = points[i][0] - points[j][0];
                int ydiff = points[i][1] - points[j][1];
                int len = xdiff * xdiff + ydiff * ydiff;
                lst.get(i).put(len, lst.get(i).getOrDefault(len, 0) + 1);
                lst.get(j).put(len, lst.get(j).getOrDefault(len, 0) + 1);
            }
        }
        int res = 0;
        for (Map<Integer, Integer> map : lst) {
            for (Integer count : map.values()) {
                res += (count - 1) * count;
            }
        }
        return res;
    }
}
