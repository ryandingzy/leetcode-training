class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 0;
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return res;
        if (endWord.equals(beginWord)) return 1;
        dict.remove(beginWord);
        res = 2;
        int wordLen = beginWord.length();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                char[] charArray = currWord.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char origin = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;
                        String nextWord = String.valueOf(charArray);
                        if (!dict.contains(nextWord)) continue;
                        dict.remove(nextWord);
                        queue.offer(nextWord);
                        if (nextWord.equals(endWord)) return res;
                    }
                    charArray[j] = origin;
                }
            }
            res++;
        }
        return 0;
    }
}
