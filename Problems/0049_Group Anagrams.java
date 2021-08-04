// My Solution
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        List<HashMap<Character, Integer>> lst = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            // construct new map
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < strs[i].length(); j++) {
                int value = map.getOrDefault(strs[i].charAt(j), 0);
                map.put(strs[i].charAt(j), value + 1);
            }
            
            // match and save
            int m;
            for (m = 0; m < lst.size(); m++) {
                if (map.size() == lst.get(m).size()) {
                    boolean match = true;
                    for (Character key : map.keySet()) {
                        if (!lst.get(m).containsKey(key) || map.get(key) != lst.get(m).get(key)) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        res.get(m).add(strs[i]);
                        break;
                    }
                }
            }
            // creat new group
            if (m == lst.size()) {
                lst.add(map);
                List<String> newLst = new ArrayList<>();
                newLst.add(strs[i]);
                res.add(newLst);
            }
        }
        return res;
    }
}

// Better Solution
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
