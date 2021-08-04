class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char num = s.charAt(0);
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == num) {
                    count++;
                } else {
                    sb.append((char)(count + '0'));
                    sb.append(num);
                    num = s.charAt(j);
                    count = 1;
                }
            }
            sb.append((char)(count + '0'));
            sb.append(num);
            
            s = sb.toString();
        }
        return s;
    }
}
