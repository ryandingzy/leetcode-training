class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i <= 4 && i <= turnedOn; i++) {
            List<Integer> lstH = new ArrayList<>();
            dfsH(i, 3, 0, lstH);
            
            List<Integer> lstM = new ArrayList<>();
            dfsM(turnedOn - i, 5, 0, lstM);
            
            for (int h : lstH) {
                for (int m : lstM) {
                    res.add(getTime(h, m));
                }
            }
        }
        return res;
    }
    
    private String getTime(int h, int m) {
        String strM = m <= 9 ? "0" + m : Integer.toString(m);
        return h + ":" + strM;
    }
    
    private void dfsH(int n, int start, int h, List<Integer> lst) {
        if (n == 0) {
            lst.add(h);
            return;
        }
        for (int i = start; i >= 0; i--) {
            if (n > i + 1) break;
            
            int value = 1 << i;
            if (h + value > 11)
                continue;
            dfsH(n - 1, i - 1, h + value, lst);
        }
    }
    
    private void dfsM(int n , int start, int m, List<Integer> lst) {
        if (n == 0) {
            lst.add(m);
            return;
        }
        for (int i = start; i >= 0; i--) {
            if (n > i + 1) break;
            
            int value = 1 << i;
            if (m + value > 59)
                continue;
            
            dfsM(n - 1, i - 1, m + value, lst);
        }
    }
}


// bitCount
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }
}
