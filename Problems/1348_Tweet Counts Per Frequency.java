class TweetCounts {
    Map<String, TreeMap<Integer, Integer>> map;

    public TweetCounts() {
        map = new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        if (!map.containsKey(tweetName)) {
            map.put(tweetName, new TreeMap<Integer, Integer>());
        }
        TreeMap<Integer, Integer> tm = map.get(tweetName);
        tm.put(time, tm.getOrDefault(time, 0) + 1);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> res = new ArrayList<>();
        if (!map.containsKey(tweetName))
            return res;
        
        TreeMap<Integer, Integer> tm = map.get(tweetName);
        int gap = getGap(freq);
        int start = startTime;
        int end = Math.min(endTime, start+gap - 1);
        Map.Entry<Integer, Integer> entry = tm.ceilingEntry(startTime);
        while (start <= end) {
            int count = 0;
            while (entry != null && entry.getKey() <= end) {
                count += entry.getValue();
                entry = tm.higherEntry(entry.getKey());
            }
            res.add(count);
            start = end + 1;
            end = Math.min(endTime, start + gap - 1);
        }
        return res;
    }
    
    public int getGap(String freq) {
        if (freq.equals("minute")) {
            return 60;
        } else if (freq.equals("hour")) {
            return 60 * 60;
        } else {
            return 60 * 60 * 24;
        }
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
 