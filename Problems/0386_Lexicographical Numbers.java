class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        
        dfs(0, n, res);
        return res;
    }
    
    public void dfs(int num, int n, List<Integer> res) {
        for (int i = 0; i <= 9; i++) {
            int newNum = num * 10 + i;
            if (newNum == 0)
                continue;
            
            if (newNum <= n) {
                res.add(newNum);
                dfs(newNum, n, res);
            } else {
                return;
            }
        }
    }
}
