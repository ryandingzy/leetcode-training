class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> lst = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            lst.add(entry);
        }
        Collections.sort(lst, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue() == e2.getValue()) {
                    return e1.getKey().compareTo(e2.getKey());
                } else {
                    return e2.getValue() - e1.getValue();
                }
            }
        });
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> e : lst) {
            res.add(e.getKey());
            if (res.size() == k) break;
        }
        return res;
    }
}
