class Solution {
    private static final char[][] PAIRS = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    private int count = 0;
    private String low;
    private String high;
    
    public int strobogrammaticInRange(String low, String high) {
        this.low = low;
        this.high = high;
        
        for (int i = low.length(); i <= high.length(); i++) {
            dfs(0, i-1, new char[i]);
        }
        return count;
    }
    
    private void dfs(int left, int right, char[] c) {
        if (left > right) {
            String res = new String(c);
            if (!(res.length() == low.length() && res.compareTo(low) < 0) && 
                !(res.length() == high.length() && res.compareTo(high) > 0)) {
                count++;
            }
            return;
        }
        
        for (char[] p : PAIRS) { 
            c[left] = p[0];
            c[right] = p[1];
            
            if (c.length != 1 && c[0] == '0') continue;
            if (left == right && p[0] != p[1]) continue;
            
            dfs(left + 1, right - 1, c);
        }
    } 
    
}
