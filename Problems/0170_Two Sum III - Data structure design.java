class TwoSum {
    
    private HashMap<Long, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
    }
    
    public void add(int number) {
        map.put((long)number, map.getOrDefault((long)number, 0) + 1);
    }
    
    public boolean find(int value) {
        for (long key : map.keySet()) {
            if (map.containsKey(value - key)) {
                if (value - key != key) return true;
                else if (map.get(value - key) > 1) return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
 