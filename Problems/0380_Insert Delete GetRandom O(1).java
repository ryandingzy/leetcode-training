class RandomizedSet {
    List<Integer> lst;
    HashMap<Integer, Integer> map;

    public RandomizedSet() {
        lst = new ArrayList<>();
        map = new HashMap<>();;
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        
        if (map.size() < lst.size()) {
            lst.set(map.size(), val);
            map.put(val, map.size());
        } else {
            lst.add(val);
            map.put(val, lst.size() - 1);
        }
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        
        lst.set(map.get(val), lst.get(map.size() - 1));
        map.put(lst.get(map.size() - 1), map.get(val));
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random randNum = new Random();
        return lst.get(randNum.nextInt(map.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
 