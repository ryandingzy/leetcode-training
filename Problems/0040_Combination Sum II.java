class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lsts = new ArrayList<>();
        if (candidates.length == 0) {
            return lsts;
        }
        Arrays.sort(candidates);
        List<Integer> lst = new ArrayList<>();
        for (int i = candidates.length - 1; i >= 0; i--) {
            if (candidates[i] <= target) {
                search(candidates, i, target, lst, lsts);
                break;
            }
        }
        return lsts;
    }
    
    private void search(int[] candidates, int limitIdx, int target, List<Integer> lst, List<List<Integer>> lsts) {
        int diff;
        for (int i = limitIdx; i >= 0; i--) {
            if (i < limitIdx && candidates[i] == candidates[i+1])
                continue;
            List<Integer> newLst = new ArrayList<>();
            newLst.addAll(lst);
            newLst.add(candidates[i]);
            diff = target - candidates[i];
            if (diff == 0) {
                lsts.add(newLst);
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (candidates[j] <= diff) {
                        search(candidates, j, diff, newLst, lsts);
                        break;
                    }
                }
            }
        }
    }
}
