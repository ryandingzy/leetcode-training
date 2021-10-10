/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        sb.append(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sb.append(" ");
            if (node.left != null) {
                sb.append(node.left.val);
                queue.offer(node.left);
            } else {
                sb.append("$");
            }
            sb.append(" ");
            if (node.right != null) {
                sb.append(node.right.val);
                queue.offer(node.right);
            } else {
                sb.append("$");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] strs = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (strs[i].equals("$")) node.left = null;
            else {
                node.left = new TreeNode(Integer.valueOf(strs[i]));
                queue.offer(node.left);
            }
            i++;
            if (strs[i].equals("$")) node.right = null;
            else {
                node.right = new TreeNode(Integer.valueOf(strs[i]));
                queue.offer(node.right);
            } 
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
