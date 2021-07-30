class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lsts = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        lsts.add(new ArrayList<>(lst));
        
        Arrays.sort(nums);
        dfs(lsts, lst, nums, 0);
        return lsts;
    }
    
    public void dfs(List<List<Integer>> lsts, List<Integer> lst, int[] nums, int first) {
        for (int i = first; i < nums.length; i++) {
            if (i != first && nums[i] == nums[i-1])
                continue;
            lst.add(nums[i]);
            lsts.add(new ArrayList<>(lst));
            dfs(lsts, lst, nums, i + 1);
            lst.remove(lst.size() - 1);
        }
    }
}
