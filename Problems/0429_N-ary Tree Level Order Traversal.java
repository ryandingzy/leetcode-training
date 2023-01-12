/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        res.add(rootList);
        while (!queue.isEmpty()) {
            List<Integer> lst = new ArrayList<>();
            while (count > 0) {
                Node node = queue.poll();
                for (Node child : node.children) {
                    lst.add(child.val);
                    queue.offer(child);
                }
                count--;
            }
            count = lst.size();
            if (count != 0) res.add(lst);
        }
        return res;
    }
}
