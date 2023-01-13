class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }
        Map<Integer, Integer> idsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idsMap.put(intervals[i][0], i);
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] - arr2[0];
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int id = idsMap.get(start);
            while (!pq.isEmpty() && pq.peek()[1] <= start) {
                res[idsMap.get(pq.poll()[0])] = id;
            }
            if (start >= end) {
                res[id] = id;
            } else {
                pq.offer(intervals[i]);
            }
        }
        return res;
    }
}
