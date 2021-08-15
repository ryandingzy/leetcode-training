class Solution {
    public String reverseWords(String s) {
        // delete space
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (i == 0 || s.charAt(i - 1) == ' ') continue;
                else sb.append(' ');
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1);
        
        // reverse the string
        int i = 0, j = sb.length() -1;
        while (i < j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }
        
        // reverse every word
        i = 0;
        j = 0;
        while (i < sb.length()) {
            while (j != sb.length() - 1 && sb.charAt(j+1) != ' ') {
                j++;
            }
            int next = j + 2;
            while (i < j) {
                char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);
                i++;
                j--;
            }
            if (next >= sb.length()) break;
            i = next;
            j = next;
        }
        
        return sb.toString();
    }
}
