class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                if (i1[0] == i2[0]) {
                    return i1[1] - i2[1];
                } else {
                    return i1[0] - i2[0];
                }
            }
        });

        int last = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < last) {
                count++;
                last = Math.min(last, intervals[i][1]);
            } else {
                last = intervals[i][1];
            }
        }
        return count;
    }
}
