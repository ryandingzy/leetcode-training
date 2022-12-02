class Solution {
    public boolean checkRecord(String s) {
        int countA = 0;
        int countC = 0;
        boolean late = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                countA++;
                countC = 0;
            } else if (s.charAt(i) == 'L') {
                countC++;
                if (countC == 3) {
                    late = true;
                }
            } else {
                countC = 0;
            }
        }
        return !late && (countA < 2);
    }
}
