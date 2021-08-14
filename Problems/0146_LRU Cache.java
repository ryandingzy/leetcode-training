// My solution -- too slow
class ListNode {
    int key;
    int value;
    ListNode next;
    public ListNode() {}
    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    ListNode head;
    ListNode tail;
    int size;
    int capacity;
    
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode();
        tail = head;
        size = 0;
    }
    
    public int get(int key) {
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.key == key) {
                if (cur != tail) {
                    pre.next = cur.next;
                    cur.next = null;
                    tail.next = cur;
                    tail = cur;
                }
                return cur.value;
            }
            pre = cur;
            cur = cur.next;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.key == key) {
                cur.value = value;
                if (cur != tail) {
                    pre.next = cur.next;
                    cur.next = null;
                    tail.next = cur;
                    tail = cur;
                }
                return;
            }
            pre = cur;
            cur = cur.next;
        }
        
        // add
        ListNode newNode = new ListNode(key, value);
        tail.next = newNode;
        tail = newNode;
        size++;
        
        if (size > capacity) {
            head.next = head.next.next;
            size--;
        }
    }
}

// Linked HashMap
class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
}

// construct linkedHashMap
public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
