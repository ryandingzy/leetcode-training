class MovingAverage {
    int n;
    Queue<Integer> queue;
    int sum;

    public MovingAverage(int size) {
        n = size;
        queue = new LinkedList<>();
        sum = 0;
    }
    
    public double next(int val) {
        if (queue.size() < n) {
            queue.offer(val);
            sum += val;
        } else {
            sum -= queue.poll();
            queue.offer(val);
            sum += val;
        }
        return (double)sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
 