class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        if (rowIndex == 0) return lst;
        if (rowIndex == 1) {
            lst.add(1);
            return lst;
        }
        lst.add(rowIndex);
        long num = rowIndex;
        for (int i = 2; i <= rowIndex / 2; i++) {
            if (i > rowIndex - i + 1) {
                num /= i;
                num *= rowIndex - i + 1;
            } else {
                num *= rowIndex - i + 1;
                num /= i;
            }
            //molecular *= rowIndex - i + 1;
            //denominator *= i;
            lst.add((int)num);
        }
        int idx = lst.size() - 2;
        if (rowIndex % 2 == 1) lst.add(lst.get(lst.size() - 1));
        for (; idx >= 0; idx--) {
            lst.add(lst.get(idx));
        }
        return lst;
    }
}
