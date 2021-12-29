class LogSystem {
    TreeMap<Long, List<Integer>> tm;
    HashMap<String, Integer> map;

    public LogSystem() {
        tm = new TreeMap<>();
        
        map = new HashMap<>();
        map.put("Year", 4);
        map.put("Month", 7);
        map.put("Day", 10);
        map.put("Hour", 13);
        map.put("Minute", 16);
        map.put("Second", 19);
    }
    
    public void put(int id, String timestamp) {
        long key = getKey(timestamp, "Second", true);
        
        if (!tm.containsKey(key))
            tm.put(key, new ArrayList<>());
        tm.get(key).add(id);
    }
    
    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> res = new ArrayList<>();
        long l = getKey(start, granularity, true);
        long h = getKey(end, granularity, false);
        
        Map.Entry<Long, List<Integer>> entry = tm.ceilingEntry(l);
        while (entry != null && entry.getKey() <= h) {
            List<Integer> ids = entry.getValue();
            for (int i = 0; i < ids.size(); i++) {
                res.add(ids.get(i));
            }
            entry = tm.higherEntry(entry.getKey());
        }
        return res;
    }
    
    private long getKey(String time, String g, Boolean small) {
        int len = map.get(g);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) == ':')
                continue;
            if (i >= len) {
                if (small) sb.append("0");
                else sb.append("9");
            } else {
                sb.append(time.charAt(i));
            }
        }
        return Long.valueOf(sb.toString());
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */
 