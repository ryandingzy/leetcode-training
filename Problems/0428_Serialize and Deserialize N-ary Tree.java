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

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return sb.toString();
        sb.append(root.val);
        sb.append(' ');
        if (root.children.size() == 0) return sb.toString();
        sb.append("[");
        for (int i = 0; i < root.children.size(); i++) {
            // if (i != 0) sb.append(' ');
            sb.append(serialize(root.children.get(i)));
            sb.append(' ');
        }
        sb.append("]");
        return sb.toString();
    }

    private List<Node> deserialize(String data, int start, int end, Map<Integer, Integer> map) {
        List<Node> res = new ArrayList<>();
        int begin = -1;
        for (int i = start; i <= end; i++) {
            if (data.charAt(i) == ' ') {
                if (begin == -1) continue;
                Node newNode = new Node(Integer.valueOf(data.substring(begin, i)), new ArrayList<Node>());
                begin = -1;
                if (i + 1 <= end && data.charAt(i + 1) == '[') {
                    int next = map.get(i + 1);
                    newNode.children = deserialize(data, i + 2, next - 1, map);
                    i = next + 1;
                }
                res.add(newNode);
            } else {
                if (begin == -1) begin = i;
            }
        }
        return res;
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == "") return null;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '[') {
                stack.addLast(i);
            } else if (data.charAt(i) == ']') {
                int last = stack.pollLast();
                map.put(last, i);
            }
        }
        List<Node> lst = deserialize(data, 0, data.length() - 1, map);
        return lst.get(0);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
