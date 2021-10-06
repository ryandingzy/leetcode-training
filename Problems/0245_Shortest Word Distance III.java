class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int id1 = -1000000;
        int id2 = -1000000;
        int res = 1000000;
        for (int i = 0; i < wordsDict.length; i++) {
            String cur = wordsDict[i];
            if (word1.equals(word2)) {
                if (cur.equals(word1)) {
                    res = Math.min(res, i - id1);
                    id1 = i;
                }
            } else {
                if (cur.equals(word1)) {
                    res = Math.min(res, i - id2);
                    id1 = i;
                } else if (cur.equals(word2)) {
                    res = Math.min(res, i - id1);
                    id2 = i;
                }
            }
        }
        return res;
    }
}
