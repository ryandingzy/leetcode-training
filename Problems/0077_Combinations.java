class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lsts = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        
        dfs(lsts, lst, n, k);
        
        return lsts;
    }
    
    public void dfs(List<List<Integer>> lsts, List<Integer> lst, int n, int k) {
        if (lst.size() == k)
            lsts.add(new ArrayList<>(lst));
        
        int first = (lst.size() == 0) ? 1 : lst.get(lst.size() - 1) + 1;
        for (int i = first; i <= n; i++) {
            if (n - i + 1 + lst.size() < k)
                return;
            lst.add(i);
            dfs(lsts, lst, n, k);
            lst.remove(lst.size() - 1);
        }
    }
}
