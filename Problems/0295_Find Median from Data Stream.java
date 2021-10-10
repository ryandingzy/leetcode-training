class MedianFinder {
    PriorityQueue<Integer> heapMin;
    PriorityQueue<Integer> heapMax;

    public MedianFinder() {
        heapMin = new PriorityQueue<Integer>();
        heapMax = new PriorityQueue<Integer>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        heapMax.offer(num);
        heapMin.offer(heapMax.poll());
        if (heapMin.size() > heapMax.size()) {
            heapMax.add(heapMin.poll());
        }
    }
    
    public double findMedian() {
        if (heapMin.size() == heapMax.size())
            return (double) (heapMax.peek() + heapMin.peek()) * 0.5;
        else
            return (double) heapMax.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
 