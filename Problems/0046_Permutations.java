class Solution {
    Map<Integer, Boolean> map = new HashMap<>();
    public List<List<Integer>> permute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], false);
        }
        List<List<Integer>> lsts = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> lst = new ArrayList<>();
            lst.add(nums[i]);
            map.put(nums[i], true);
            if (lst.size() == nums.length) {
                lsts.add(lst);
            } else {
                dfs(lsts, lst, nums, i);
            }
            map.put(nums[i], false);
        }
        return lsts;
    }
    
    public void dfs(List<List<Integer>> lsts, List<Integer> lst, int[] nums, int pos) {
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i])) continue;
            
            List<Integer> newLst = new ArrayList<>();
            newLst.addAll(lst);
            newLst.add(nums[i]);
            map.put(nums[i], true);
            if (newLst.size() == nums.length) {
                lsts.add(newLst);
            } else {
                dfs(lsts, newLst, nums, i);
            }
            map.put(nums[i], false);
        }
    }
}

// samplifier style
import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(path);
            return;
        }

        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1); // could be helpful to backtrace
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }
}
