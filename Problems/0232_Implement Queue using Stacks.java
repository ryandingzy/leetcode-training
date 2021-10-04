class MyQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (stack1.isEmpty()) {
            stack1.addLast(x);
        } else {
            stack2.addLast(x);
        }
    }
    
    public int pop() {
        int num = stack1.pollLast();
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.addLast(stack2.pollLast());
            }
        }
        return num;
    }
    
    public int peek() {
        return stack1.peekLast();
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
 