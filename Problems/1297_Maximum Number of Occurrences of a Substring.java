class Solution {
    String s;
    int minSize;
    Map<String, Integer> record;
    
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        this.s = s;
        this.minSize = minSize;
        record = new HashMap<>();
        int res = 0;
        for (int i = 0; i <= n - minSize; i++) {
            String sub = s.substring(i, i+minSize);
            if (getNum(sub) > maxLetters)
                continue;
            record.put(sub, record.getOrDefault(sub, 0) + 1);
        }
        for (int each : record.values())
            res = Math.max(res, each);
        return res;
    }
    
    public int getNum(String str) {
        Set<Integer> count = new HashSet<>();
        for (char ch : str.toCharArray()) {
            count.add(ch - 'a');
        }
        return count.size();
    }
}
