class Node {
    public Node pre;
    public Node next;
    public int count;
    public Set<String> keys;
    public Node(int _count) {
        keys = new HashSet<String>();
        pre = null;
        next = null;
        count = _count;
    }
}

class AllOne {
    Node max;
    Node min;
    Map<String, Integer> countMap;
    Map<Integer, Node> nodeMap;

    public AllOne() {
        max = new Node(0);
        min = max;
        countMap = new HashMap<>();
        nodeMap = new HashMap<>();
    }
    
    public void inc(String key) {
        if (countMap.containsKey(key)) {
            int curCount = countMap.get(key);
            countMap.put(key, curCount + 1);

            // node list
            // current node
            Node node = nodeMap.get(curCount);
            node.keys.remove(key);

            // next node
            if (nodeMap.containsKey(curCount + 1)) {
                nodeMap.get(curCount + 1).keys.add(key);
            } else {
                Node newNode = new Node(curCount + 1);
                newNode.keys.add(key);
                if (max == node) {
                    max = newNode;
                } else {
                    newNode.next = node.next;
                    node.next.pre = newNode;
                }
                newNode.pre = node;
                node.next = newNode;

                nodeMap.put(curCount + 1, newNode);
            }

            // delete current node
            if (node.keys.isEmpty()) {
                node.next.pre = node.pre;
                node.pre.next = node.next;
                nodeMap.remove(node.count);
            }
        } else {
            countMap.put(key, 1);
            if (max != min && min.next.count == 1) {
                min.next.keys.add(key);
            } else {
                Node newNode = new Node(1);
                newNode.keys.add(key);
                if (max == min) {
                    max = newNode;
                } else {
                    min.next.pre = newNode;
                    newNode.next = min.next;
                }
                min.next = newNode;
                newNode.pre = min;

                nodeMap.put(1, newNode);
            }
        }
        // printStack();
    }
    
    public void dec(String key) {
        if (!countMap.containsKey(key)) return;
        int count = countMap.get(key);
        if (count == 1) {
            countMap.remove(key);
            Node curNode = nodeMap.get(1);
            curNode.keys.remove(key);
            if (curNode.keys.isEmpty()) {
                if (max == curNode) {
                    max = curNode.pre;
                    min.next = null;
                } else {
                    curNode.next.pre = curNode.pre;
                    min.next = curNode.next;
                }
                nodeMap.remove(curNode.count);
            }
        } else {
            countMap.put(key, count - 1);
            // current node
            Node curNode = nodeMap.get(count);
            curNode.keys.remove(key);
            // next node
            if (nodeMap.containsKey(count - 1)) {
                nodeMap.get(count - 1).keys.add(key);
            } else {
                Node newNode = new Node(count - 1);
                newNode.keys.add(key);
                newNode.pre = curNode.pre;
                newNode.next = curNode;
                curNode.pre.next = newNode;
                curNode.pre = newNode;

                nodeMap.put(count - 1, newNode);
            }
            // delete current node
            if (curNode.keys.isEmpty()) {
                if (max == curNode) {
                    max = curNode.pre;
                    max.next = null;
                } else {
                    curNode.next.pre = curNode.pre;
                    curNode.pre.next = curNode.next;
                }
                nodeMap.remove(curNode.count);
            }
        }
        // printStack();
    }
    
    public String getMaxKey() {
        // printStack();
        if (max == min) return "";
        else return max.keys.iterator().next();
    }
    
    public String getMinKey() {
        // printStack();
        if (max == min) return "";
        else return min.next.keys.iterator().next();
    }

    private void printStack() {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        Node cur = min.next;
        while (cur != null) {
            sb.append("[" + cur.count);
            for (String key : cur.keys) {
                sb.append("-" + key);
            }
            sb.append("] ");
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
 