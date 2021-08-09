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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int num = 1;
        int next = 0;
        int level = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) return level;
            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }
            
            if (--num == 0) {
                num = next;
                next = 0;
                level++;
            }
        }
        return level - 1;
    }
}
