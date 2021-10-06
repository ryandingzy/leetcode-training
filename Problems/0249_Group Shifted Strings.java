class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map =new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            StringBuilder sb = new StringBuilder();
            String str = strings[i];
            sb.append(Integer.toString(str.length()) + "-");
            for (int j = 1; j <= str.length(); j++) {
                if (j == str.length()) {
                    sb.append(Integer.toString((str.charAt(0) + 26 - str.charAt(j-1)) % 26) + "-");
                } else {
                    sb.append(Integer.toString((str.charAt(j) + 26 - str.charAt(j-1)) % 26) + "-");
                }
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<String>() {{add(str);}});
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }
}
