class Solution {
    public int romanToInt(String s) {
        int i = 0;
        int num = 0;
        while (i < s.length()) {
            switch (s.charAt(i)) {
                case 'M': num += 1000; i++; break;
                case 'D': num += 500; i++; break;
                case 'C': {
                    if (i + 1 < s.length() && s.charAt(i+1) == 'M') { num += 900; i += 2; }
                    else if (i + 1 < s.length() && s.charAt(i+1) == 'D') { num += 400; i += 2; }
                    else { num += 100; i++; }
                    break;
                }
                case 'L': num += 50; i++; break;
                case 'X': {
                    if (i + 1 < s.length() && s.charAt(i+1) == 'C') { num += 90; i += 2; }
                    else if (i + 1 < s.length() && s.charAt(i+1) == 'L') { num += 40; i += 2; }
                    else { num += 10; i++; }
                    break;
                }
                case 'V': num += 5; i++; break;
                case 'I': {
                    if (i + 1 < s.length() && s.charAt(i+1) == 'X') { num += 9; i += 2; }
                    else if (i + 1 < s.length() && s.charAt(i+1) == 'V') { num += 4; i += 2; }
                    else { num += 1; i++; }
                    break;
                }
            }
        }
        return num;
    }
}
