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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lsts = new ArrayList<>();
        if (root == null) return lsts;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int num = 1;
        int level = 1;
        
        List<Integer> lst = new ArrayList<>();
        lst.add(root.val);
        lsts.add(new ArrayList<Integer>(lst));
        lst.clear();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                lst.add(node.left.val);
                queue.offer(node.left);
            }
            if (node.right != null) {
                lst.add(node.right.val);
                queue.offer(node.right);
            }
            if (--num == 0 && !lst.isEmpty()) {
                if (++level % 2 == 0) {
                    Collections.reverse(lst);
                }
                lsts.add(new ArrayList<Integer>(lst));
                num = lst.size();
                lst.clear();
            }
        }
        return lsts;
    }
}
