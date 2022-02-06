class CustomStack {
    int[] valueStack;
    int[] incrementStack; //to save the increment of the correspondent value
    int size;
    int cur = 0; //next place to insert new element
    
    public CustomStack(int maxSize) {
        size = maxSize;
        valueStack = new int[maxSize];
        incrementStack = new int[maxSize];
    }

    //standard pushing
    public void push(int x) {
        if (cur >= size) return;
        valueStack[cur++] = x;
    }
    
    public int pop() {
        if (cur == 0) return -1;
        
        int icr = incrementStack[--cur]; //taking out the respective increment for the popped value
        incrementStack[cur] = 0; //the increment of this popped value return to 0
        if (cur > 0) incrementStack[cur-1] += icr; //because the increment is applied to "the bottom k", this increment cummulate with the increment below it
        
        return valueStack[cur] + icr;
    }
    
    public void increment(int k, int val) {
        if (cur == 0) return;
        incrementStack[Math.min(k-1, cur-1)] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
