class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> lsts = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        dfs(n, 2, lst, lsts);
        return lsts;
    }
    
    public void dfs(int n, int start, List<Integer> lst, List<List<Integer>> lsts) {
        if (n == 1) {
            if (lst.size() >= 2)
                lsts.add(new ArrayList<>(lst));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                lst.add(i);
                dfs(n / i, i, lst, lsts);
                lst.remove(lst.size() - 1);
            }
        }
    }
}
