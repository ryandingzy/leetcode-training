class WordDistance {
    HashMap<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (map.containsKey(wordsDict[i])) {
                map.get(wordsDict[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(wordsDict[i], list);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> lst1 = map.get(word1);
        List<Integer> lst2 = map.get(word2);
        int id1 = 0;
        int id2 = 0;
        int res = 30000;
        while (id1 < lst1.size() && id2 < lst2.size()) {
            if (lst1.get(id1) > lst2.get(id2)) {
                res = Math.min(res, lst1.get(id1) - lst2.get(id2));
                id2++;
            } else {
                res = Math.min(res, lst2.get(id2) - lst1.get(id1));
                id1++;
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
 