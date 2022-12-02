class Solution {
    private boolean possible(String s, String d) {
        int si = 0;
        int di = 0;
        int sn = s.length();
        int dn = d.length();
        if (dn > sn) return false;
        while (di < dn && si < sn) {
            if (s.charAt(si) == d.charAt(di)) {
                si++;
                di++;
            } else {
                si++;
            }
        }
        return di == dn;
    }

    public String findLongestWord(String s, List<String> dictionary) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        int maxLen = 0;
        for (String d : dictionary) {
            int len = d.length();
            if (len > n) continue;
            if (len >= maxLen) {
                if (possible(s, d)) {
                    if (len == maxLen) {
                        res.add(d);
                    } else {
                        res.clear();
                        res.add(d);
                        maxLen = len;
                    }
                }
            }
        }
        Collections.sort(res);
        if (res.isEmpty()) return "";
        return res.get(0);
    }
}
