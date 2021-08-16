class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) {this.val = val;}
}

class MinStack {
    ListNode head;
    ListNode tail;
    
    ListNode queue;
    
    /** initialize your data structure here. */
    public MinStack() {
        head = new ListNode();
        tail = head;
        queue = new ListNode();
    }
    
    public void push(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        
        ListNode tmp = new ListNode(val);
        ListNode pos = queue;
        while (pos.next != null && val >= pos.next.val) {
            pos = pos.next;
        }
        tmp.next = pos.next;
        pos.next = tmp;
    }
    
    public void pop() {
        int topVal = head.val;
        head = head.next;
        
        ListNode pos = queue;
        while (pos.next != null && topVal != pos.next.val) {
            pos = pos.next;
        }
        pos.next = pos.next.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return queue.next.val;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

 class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }
    
    public void pop() {
        xStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return xStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
