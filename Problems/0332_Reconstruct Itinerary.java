class Solution {
    
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        
        int n = tickets.size();
        
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(tickets.get(i).get(0))) {
                map.put(tickets.get(i).get(0), new ArrayList<String>());
            }
            map.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
        }
        
        List<String> lst = new ArrayList<String>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            lst.add(entry.getKey());
            Collections.sort(entry.getValue());
        }
        
        res.add("JFK");
        dfs(map, "JFK", res, n);
        return res;
    }
    
    public boolean dfs(HashMap<String, List<String>> map, String cur, List<String> res, int n) {
        if (res.size() == n + 1) return true;
        
        if (!map.containsKey(cur)) return false;
        List<String> next = map.get(cur);
        
        for (int i = 0; i < next.size(); i++) {
            String tmp = next.get(i);
            if (tmp.equals("")) continue;
            
            next.set(i, "");
            res.add(tmp);
            if (dfs(map, tmp, res, n)) return true;
            res.remove(res.size() - 1);
            next.set(i, tmp);
        }
        return false;
    }
}
