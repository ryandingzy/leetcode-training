class Solution {
    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == '(') {
                count++;
            } else if (arr[i] == ')') {
                if (count == 0) {
                    arr[i] = '#';
                } else {
                    count--;
                }
            }
        }
        
        int idx = len - 1;
        while (count > 0) {
            if (arr[idx] == '(') {
                arr[idx] = '#';
                count--;
            }
            idx--;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if ('#' != c) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
