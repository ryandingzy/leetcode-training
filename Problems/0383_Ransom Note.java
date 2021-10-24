class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        return map.isEmpty();
    }
}
