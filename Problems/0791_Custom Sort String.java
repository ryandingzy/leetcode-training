class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        Arrays.fill(count, -1);
        
        int lenO = order.length();
        for (int i = 0; i < lenO; i++) {
            int pos = order.charAt(i) - 'a';
            count[pos] = 0;
        }
        
        int lenS = s.length();
        char[] res = new char[lenS];
        int id = 0;
        for (int i = 0; i < lenS; i++) {
            int pos = s.charAt(i) - 'a';
            if (count[pos] == -1) {
                res[id++] = s.charAt(i);
            } else {
                count[pos]++;
            }
        }
        
        for (int i = 0; i < lenO; i++) {
            int pos = order.charAt(i) - 'a';
            while (count[pos] > 0) {
                res[id++] = order.charAt(i);
                count[pos]--;
            }
        }
        return new String(res);
    }
}
