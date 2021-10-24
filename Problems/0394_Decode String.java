class Solution {
    public String decodeString(String s) {
        return decode(s, 0, s.length() - 1);
    }
    
    public String decode(String s, int left, int right) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = left; i <= right; i++) {
            if (Character.isLetter(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                // search number
                int j = i + 1;
                while (s.charAt(j) != '[') j++;
                int num = Integer.valueOf(s.substring(i, j));
                
                // search range
                int count = 1;
                int k = j + 1;
                while (true) {
                    if (s.charAt(k) == '[')
                        count++;
                    else if (s.charAt(k) == ']') {
                        count--;
                        if (count == 0)
                            break;
                    }
                    k++;
                }
                
                // repeat string
                String str = decode(s, j + 1, k - 1);
                for (int t = 0; t < num; t++) {
                    sb.append(str);
                }
                
                i = k;
            }
        }
        
        return sb.toString();
    }
}
