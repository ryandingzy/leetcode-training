class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lsts = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        for (int i = candidates.length - 1; i >= 0; i--) {
            if (candidates[i] <= target) {
                Search(candidates, i, target, lst, lsts);
                break;
            }
        }
        return lsts;
    }
    
    private void Search(int[] candidates, int limitIdx, int target, List<Integer> lst,  List<List<Integer>> lsts) {
        int diff;
        for (int i = limitIdx; i >= 0; i--) {
            // copy
            List<Integer> newLst = new ArrayList<>();
            newLst.addAll(lst);
            diff = target - candidates[i];
            newLst.add(candidates[i]);
            if (diff == 0) {
                // get
                lsts.add(newLst);
            } else {
                // search diff
                for (int j = i; j >= 0; j--) {
                    if (diff >= candidates[j]) {
                        Search(candidates, j, diff, newLst, lsts);
                        break;
                    }
                }
            }
        }
    }
}

