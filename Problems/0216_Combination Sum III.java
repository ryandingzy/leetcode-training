class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        dfs(k, n, 9, lst, res);
        return res;
    }
    
    public void dfs(int k, int n, int start, List<Integer> lst, List<List<Integer>> res) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<Integer>(lst));
            } else return;
        }
        for (int i = start; i > 0; i--) {
            if (i > n) continue;
            lst.add(i);
            dfs(k - 1, n - i, i - 1, lst, res);
            lst.remove(lst.size() - 1);
        }
    }
}
