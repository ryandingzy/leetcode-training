class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int idx1 = 0;
        int idx2 = 0;
        int len1 = word.length();
        int len2 = abbr.length();
        int count = 0;
        while (idx1 < len1 && idx2 < len2) {
            if (Character.isLetter(abbr.charAt(idx2))) {
                if (word.charAt(idx1) == abbr.charAt(idx2)) {
                    idx1++;
                    idx2++;
                } else {
                    return false;
                }
            } else {
                int num = abbr.charAt(idx2) - '0';
                if (num == 0)
                    return false;
                idx2++;
                while (idx2 < len2 && Character.isDigit(abbr.charAt(idx2))) {
                    num *= 10;
                    num += abbr.charAt(idx2) - '0';
                    idx2++;
                }
                idx1 += num;
            }
        }
        return idx1 == len1 && idx2 == len2;
    }
}
