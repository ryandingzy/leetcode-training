class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> lsts = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        dfs(nums, 0, lst, lsts);
        
        // remove duplicates
        List<List<Integer>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < lsts.size(); i++) {
            String str = getStr(lsts.get(i));
            if (set.contains(str)) {
                continue;
            }
            res.add(lsts.get(i));
            set.add(str);
        }
        
        return res;
    }
    
    private String getStr(List<Integer> lst) {
        StringBuilder sb = new StringBuilder();
        for (int num : lst) {
            sb.append(num);
            sb.append("-");
        }
        return sb.toString();
    }
    
    private void dfs(int[] nums, int start, List<Integer> lst, List<List<Integer>> lsts) {
        if (lst.size() >= 2) {
            lsts.add(new ArrayList<Integer>(lst));
        }
        
        for (int i = start; i < nums.length; i++) {
            int next = nums[i];
            if (lst.size() != 0 && lst.get(lst.size() - 1) > next)
                continue;
            lst.add(next);
            dfs(nums, i + 1, lst, lsts);
            lst.remove(lst.size() - 1);
        }
    }
}