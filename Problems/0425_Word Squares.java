class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        int n = words[0].length();
        // 1
        if (n == 1) {
            for (String word : words) {
                res.add(Arrays.asList(word));
            }
            return res;
        }
        // 2
        Map<Character, List<String>> map1 = new HashMap<>();
        for (String word : words) {
            char first = word.charAt(0);
            if (!map1.containsKey(first)) {
                map1.put(first, new ArrayList<String>());               
            }
            map1.get(first).add(word);
        }

        if (n == 2) {
            for (String first : words) {
                if (!map1.containsKey(first.charAt(1))) continue;
                for (String second : map1.get(first.charAt(1))) {
                    res.add(Arrays.asList(first, second));
                }
            }
            return res;
        }

        // 3
        Map<String, List<String>> map2 = new HashMap<>();
        for (String word : words) {
            String key = word.substring(0, 2);
            if (!map2.containsKey(key)) {
                map2.put(key, new ArrayList<String>());
            }
            map2.get(key).add(word);
        }

        if (n == 3) {
            for (String first : words) {
                if (map1.containsKey(first.charAt(1))) continue;
                for (String second : map1.get(first.charAt(1))) {
                    char[] arr = new char[]{first.charAt(2), second.charAt(2)};
                    String key = String.valueOf(String.valueOf(arr));
                    if (!map2.containsKey(key)) continue;
                    for (String third : map2.get(key)) {
                        res.add(Arrays.asList(first, second, third));
                    }
                }
            }
            return res;
        }

        // 4
        Map<String, List<String>> map3 = new HashMap<>();
        for (String word : words) {
            String key = word.substring(0, 3);
            if (!map3.containsKey(key)) {
                map3.put(key, new ArrayList<String>());
            }
            map3.get(key).add(word);
        }
        for (String first : words) {
            if (!map1.containsKey(first.charAt(1))) continue;
            for (String second : map1.get(first.charAt(1))) {
                char[] arr = new char[]{first.charAt(2), second.charAt(2)};
                String key = String.valueOf(arr);
                if (!map2.containsKey(key)) continue;
                for (String third : map2.get(key)) {
                    char[] arr2 = new char[]{first.charAt(3), second.charAt(3), third.charAt(3)};
                    String key2 = String.valueOf(arr2);
                    if (!map3.containsKey(key2)) continue;
                    for (String forth : map3.get(key2)) {
                        res.add(Arrays.asList(first, second, third, forth));
                    }
                }
            }
        }
        return res;
    }
}
