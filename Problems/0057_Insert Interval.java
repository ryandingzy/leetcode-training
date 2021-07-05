class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> lst = new ArrayList<>();
        
        if (intervals.length == 0) {
            lst.add(newInterval);
            return lst.toArray(new int[1][2]);
        }
        if (intervals[0][0] > newInterval[1]) {
            lst.add(newInterval);
            for (int i = 0; i < intervals.length; i++)
                lst.add(intervals[i]);
            return lst.toArray(new int[lst.size()][]);
        }
        if (intervals[intervals.length-1][1] < newInterval[0]) {
            for (int i = 0; i < intervals.length; i++)
                lst.add(intervals[i]);
            lst.add(newInterval);
            return lst.toArray(new int[lst.size()][]);
        }
        
        int i, j;
        // get i
        for (i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                lst.add(intervals[i]);
            } else {
                break;
            }
        }
        // get j
        for (j = intervals.length - 1; j >= 0; j--) {
            if (intervals[j][0] > newInterval[1]) {
                //lst.add(intervals[j]);
            } else {
                break;
            }
        }
        // construct new interval
        lst.add(new int[] {
            Math.min(newInterval[0], intervals[i][0]),
            Math.max(newInterval[1], intervals[j][1])
        });
        for (j++; j < intervals.length; j++)
            lst.add(intervals[j]);
        
        return lst.toArray(new int[lst.size()][]);
    }
}
