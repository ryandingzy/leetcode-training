class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lsts = new ArrayList<>();
        List<Integer> spaces = new ArrayList<>();
        
        lsts.add(new ArrayList<String>());
        
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (count == 0) {
                lsts.get(lsts.size() - 1).add(words[i]);
                count += words[i].length();
            } else {
                if (count + words[i].length() + 1 <= maxWidth) {
                    lsts.get(lsts.size() - 1).add(words[i]);
                    count += words[i].length() + 1;
                } else {
                    spaces.add(maxWidth - count + lsts.get(lsts.size() - 1).size() - 1);
                    count = 0;
                    lsts.add(new ArrayList<String>());
                    i--;
                }
            }
            
            if (i == words.length - 1) {
                spaces.add(maxWidth - count + lsts.get(lsts.size() - 1).size() - 1);
            }
        }
        
        // construct result
        List<String> res = new ArrayList<>();
        for (int i = 0; i < lsts.size(); i++) {
            int num = spaces.get(i);
            
            StringBuilder sb = new StringBuilder();
            List<String> lst = lsts.get(i);
            for (int j = 0; j < lst.size(); j++) {
                // append space
                if (j != 0) {
                    int spaceNum = 1;
                    if (i != lsts.size() - 1) {
                        spaceNum = num / (lst.size() - j);
                        if (num % (lst.size() - j) != 0) {
                            spaceNum++;
                        }
                    }
                    for (int k = 0; k < spaceNum; k++) {
                        sb.append(" ");
                    }
                    num -= spaceNum;
                }
                
                // append word
                sb.append(lst.get(j));
            }
            for (; num > 0; num--) {
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        return res;
    }
}
