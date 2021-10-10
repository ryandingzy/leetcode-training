class ValidWordAbbr {
    String[] dict;
    HashMap<String, Integer> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            dict = dictionary;
            String abbr = abbreviation(dictionary[i]);
            if (!map.containsKey(abbr)) map.put(abbr, i);
            else if (map.get(abbr) != -1 && !dictionary[map.get(abbr)].equals(dictionary[i])) {
                map.put(abbr, -1);
            }
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = abbreviation(word);
        if (!map.containsKey(abbr)) return true;
        if (map.get(abbr) != -1 && dict[map.get(abbr)].equals(word)) return true;
        return false;
    }
    
    private String abbreviation(String word) {
        if (word.length() <= 2) return word;
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(word.length() - 2);
        sb.append(word.charAt(word.length() - 1));
        return sb.toString();
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
 