class SummaryRanges {
    HashMap<Integer, int[]> map;

    public SummaryRanges() {
        map = new HashMap<>();
    }
    
    public void addNum(int val) {
        if (map.containsKey(val)) return;
        if (map.containsKey(val - 1) && map.containsKey(val + 1)) {
            int[] range1 = map.get(val - 1);
            int[] range2 = map.get(val + 1);
            if (range1[1] - range1[0] >= range2[1] - range2[0]) {
                range1[1] = range2[1];
                for (int i = val; i <= range2[1]; i++) {
                    map.put(i, range1);
                }
            } else {
                range2[0] = range1[0];
                for (int i = range1[0]; i <= val; i++) {
                    map.put(i, range2);
                }
            }
        } else if (map.containsKey(val - 1)) {
            int[] range = map.get(val - 1);
            range[1] = val;
            map.put(val, range);
        } else if (map.containsKey(val + 1)) {
            int[] range = map.get(val + 1);
            range[0] = val;
            map.put(val, range);
        } else {
            map.put(val, new int[] {val, val});
        }
    }
    
    public int[][] getIntervals() {
        HashSet<int[]> set = new HashSet<>();
        for (int[] value : map.values()) {
            if (!set.contains(value))
                set.add(value);
        }
        int[][] res = new int[set.size()][2];
        int i = 0;
        for (int[] range : set) {
            res[i++] = range;
        }
        
        Arrays.sort(res, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
 