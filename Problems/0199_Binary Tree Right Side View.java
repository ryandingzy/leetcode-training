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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if (root == null) return lst;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int num = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                count++;
            }
            if (node.right != null) {
                queue.add(node.right);
                count++;
            }
            if (--num == 0) {
                lst.add(node.val);
                num = count;
                count = 0;
            }
        }
        return lst;
    }
}
