class RandomizedCollection {
    List<Integer> lst;
    HashMap<Integer, HashSet<Integer>> map;

    public RandomizedCollection() {
        lst = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if (!contains)
            map.put(val, new HashSet<Integer>());
        
        lst.add(val);
        map.get(val).add(lst.size() - 1);
        return !contains;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        
        int index = map.get(val).iterator().next();
        if (map.get(val).size() == 1)
            map.remove(val);
        else
            map.get(val).remove(index);
        
        if (index == lst.size() - 1) {
            lst.remove(lst.size() - 1);
            return true;
        }
        int last = lst.get(lst.size() - 1);
        lst.set(index, last);
        map.get(last).remove(lst.size() - 1);
        map.get(last).add(index);
        lst.remove(lst.size() - 1);
        
        return true;
    }
    
    public int getRandom() {
        Random rd = new Random();
        return lst.get(rd.nextInt(lst.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
 