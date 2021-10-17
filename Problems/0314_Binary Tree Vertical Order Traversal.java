/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int max = 0;
    Queue<TreeNode> qTree = new LinkedList<>();
    Queue<Integer> qIndex = new LinkedList<>();
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        qTree.offer(root);
        qIndex.offer(0);
        while (!qTree.isEmpty()) {
            TreeNode cur = qTree.poll();
            int index = qIndex.poll();
            if (!map.containsKey(index)) {
                map.put(index, new ArrayList<Integer>());
            }
            map.get(index).add(cur.val);
            max = Math.max(max, index);
            if (cur.left != null) {
                qTree.offer(cur.left);
                qIndex.offer(index + 1);
            }
            if (cur.right != null) {
                qTree.offer(cur.right);
                qIndex.offer(index - 1);
            }
        }
        while (map.containsKey(max)) {
            res.add(map.get(max));
            max--;
        }
        return res;
    }
}
