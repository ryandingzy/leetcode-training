class Tree {
    Tree[] letters;
    boolean isEnd = false;
    public Tree() {letters = new Tree[26];}
}

class WordDictionary {
    Tree root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Tree();
    }
    
    public void addWord(String word) {
        Tree node = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (node.letters[pos] == null) {
                node.letters[pos] = new Tree();
            }
            node = node.letters[pos];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Tree node = root;
        return search(word, 0, node);
    }
    
    public boolean search(String word, int start, Tree node) {
        for (int i = start; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.letters[j] != null) {
                        Tree tmp = node.letters[j];
                        if (search(word, i + 1, tmp)) return true;
                    }
                }
                return false;
            } else {
                int pos = word.charAt(i) - 'a';
                if (node.letters[pos] == null) return false;
                node = node.letters[pos];
            }
        }
        return node.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
 