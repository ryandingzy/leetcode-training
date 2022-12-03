class Solution {
    private List<Integer> convertNumToList(int n) {
        List<Integer> res = new ArrayList<>();
        while (n > 0) {
            res.add(n % 10);
            n /= 10;
        }
        return res;
    }

    private int convertListToNum(List<Integer> lst) {
        int len = lst.size();
        if (len > 10) return -1;
        if (len == 10) {
            List<Integer> lstMax = convertNumToList(Integer.MAX_VALUE);
            for (int i = 9; i >= 0; i--) {
                if (lst.get(i) > lstMax.get(i)) {
                    return -1;
                } else if (lst.get(i) < lstMax.get(i)) {
                    break;
                }
            }
        }
        int res = lst.get(len - 1);
        for (int i = len - 2; i >= 0; i--) {
            res *= 10;
            res += lst.get(i);
        }
        return res;
    }

    public int nextGreaterElement(int n) {
        List<Integer> lst = convertNumToList(n);
        int len = lst.size();
        boolean changed = false;
        for (int i = 0; i < len - 1; i++) {
            int cur = lst.get(i);
            int next = lst.get(i+1);
            if (cur > next) {
                changed = true;
                int j = i;
                while (j > 0 && lst.get(j-1) > next) {
                    j--;
                }
                // swap next and j
                int tmp = lst.get(j);
                lst.set(j, next);
                lst.set(i+1, tmp);
                // reverse from 0 to i
                int l = 0;
                int r = i;
                while (l < r) {
                    int tmp2 = lst.get(l);
                    lst.set(l, lst.get(r));
                    lst.set(r, tmp2);
                    l++;
                    r--;
                }
                break;
            }
        }
        if (!changed) return -1;
        // compare with MAX
        return convertListToNum(lst);
    }
}
