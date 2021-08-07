class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        if (s.length() >= 4 && s.length() <= 12) dfs(s, 0, 1, res, lst);
        return res;
    }
    
    public void dfs(String s, int start, int count, List<String> res, List<Integer> lst) {
        if (count > 4) {
            StringBuilder sb = new StringBuilder(String.valueOf(lst.get(0)));
            for (int i = 1; i < lst.size(); i++) {
                sb.append('.');
                sb.append(String.valueOf(lst.get(i)));
            }
            res.add(sb.toString());
            return;
        }
        int max;
        if (s.charAt(start) == '0') max = 1;
        else if (s.length() - start - (4 - count) >= 3) max = 3;
        else max = s.length() - start - (4 - count);
        int min;
        if (s.length() - start == (5 - count) * 3) min = 3;
        else if (s.length() - start == (5 - count) * 3 - 1) min = 2;
        else min = 1;
        
        for (int i = max; i >= min; i--) {
            int num = Integer.parseInt(s.substring(start, start + i));
            if (num > 255) continue;
            lst.add(num);
            dfs(s, start + i, count + 1, res, lst);
            lst.remove(lst.size() - 1);
        }
    }
}
