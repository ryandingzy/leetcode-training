class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] - arr2[0];
            }
        });
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            if (heap.isEmpty()) heap.offer(intervals[i][1]);
            else {
                if (heap.peek() <= intervals[i][0]) {
                    heap.poll();
                }
                heap.offer(intervals[i][1]);
            }
        }
        return heap.size();
    }
}
