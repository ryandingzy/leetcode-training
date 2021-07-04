class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lsts = new ArrayList<>();
        
        if (nums.length == 0) return lsts;
        
        List<Integer> lst = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];

        dfs(nums, used, lsts, lst);
        
        return lsts;
    }
    
    public void dfs(int[] nums, boolean[] used, List<List<Integer>> lsts, List<Integer> lst) {
        if (nums.length == lst.size()) {
            lsts.add(new ArrayList<Integer>(lst));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0) && (nums[i-1] == nums[i]) && (!used[i-1]))
                continue;
            lst.add(nums[i]);
            used[i] = true;
            dfs(nums, used, lsts, lst);
            lst.remove(lst.size() - 1);
            used[i] = false;
        }
    }
}