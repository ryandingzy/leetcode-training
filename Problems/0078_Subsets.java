class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lsts = new ArrayList<>();
        
        List<Integer> lst = new ArrayList<>();
        
        lsts.add(new ArrayList<>(lst));
        
        dfs(nums, 0, lsts, lst);
        
        return lsts;
    }
    
    public void dfs(int[] nums, int first, List<List<Integer>> lsts, List<Integer> lst) {
        for (int i = first; i < nums.length; i++) {
            lst.add(nums[i]);
            lsts.add(new ArrayList<>(lst));
            if (i < nums.length - 1)
                dfs(nums, i + 1, lsts, lst);
            lst.remove(lst.size() - 1);
        }
    }
}
