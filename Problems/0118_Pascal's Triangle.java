class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lsts = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lsts.add(new ArrayList<>(lst));
        if (numRows == 1) return lsts;
        
        lst.add(1);
        lsts.add(lst);
        if (numRows == 2) return lsts;
        
        for (int i = 3; i <= numRows; i++) {
            lst = new ArrayList<Integer>();
            lst.add(1);
            List<Integer> last = lsts.get(i - 2);
            for (int j = 1; j < last.size(); j++) {
                lst.add(last.get(j-1) + last.get(j));
            }
            lst.add(1);
            lsts.add(lst);
        }
        return lsts;
    }
}
