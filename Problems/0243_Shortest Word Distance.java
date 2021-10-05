class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int last1 = -30000;
        int last2 = -30000;
        int d = 30000;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                d = Math.min(d, i - last2);
                last1 = i;
            } else if (wordsDict[i].equals(word2)) {
                d = Math.min(d, i - last1);
                last2 = i;
            }
        }
        return d;
    }
}
