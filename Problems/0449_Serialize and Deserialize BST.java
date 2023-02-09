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
        sb.append(root.val);
        sb.append('(');
        sb.append(serialize(root.left));
        sb.append(')');
        sb.append('(');
        sb.append(serialize(root.right));
        sb.append(')');
        return sb.toString();
    }

    private TreeNode dfs(String data, int start, int end, Map<Integer, Integer> map) {
        if (start == end) return null;
        String sub = data.substring(start, end);

        int l1 = sub.indexOf('(') + start;
        TreeNode node = new TreeNode(Integer.valueOf(data.substring(start, l1)));
        int l2 = map.get(l1);
        node.left = dfs(data, l1 + 1, l2, map);
        int r1 = l2 + 1;
        int r2 = map.get(r1);
        node.right = dfs(data, r1 + 1, r2, map);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '(') {
                stack.addLast(i);
            } else if (data.charAt(i) == ')') {
                map.put(stack.pollLast(), i);
            }
        }
        return dfs(data, 0, data.length(), map);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
