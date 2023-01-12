class Solution {
    public int countSegments(String s) {
        int count = 0;
        boolean letter = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (letter = true) {
                    letter = false;
                }
            } else {
                if(letter == false) {
                    count++;
                }
                letter = true;
            }
        }
        return count;
    }
}
