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

// butter solution
/*
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }
            
            path.addLast(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}
*/