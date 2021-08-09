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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lsts = new ArrayList<>();
        if (root == null) return lsts;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int num = 1;
        int next = 0;
        List<Integer> lst = new ArrayList<>();
        lst.add(root.val);
        lsts.add(new ArrayList<>(lst));
        lst.clear();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                lst.add(node.left.val);
                next++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                lst.add(node.right.val);
                next++;
            }
            if (--num == 0 && !lst.isEmpty()) {
                lsts.add(new ArrayList<Integer>(lst));
                lst.clear();
                num = next;
                next = 0;
                
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = lsts.size() - 1; i >= 0; i--) {
            res.add(lsts.get(i));
        }
        return res;
    }
}
