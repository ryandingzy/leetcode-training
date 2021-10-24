class PhoneDirectory {
    PriorityQueue<Integer> queue;
    HashSet<Integer> set;
    int max;

    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        queue = new PriorityQueue<>();
        set = new HashSet<>();
        for (int i = 0; i < maxNumbers; i++) {
            queue.offer(i);
        }
    }
    
    public int get() {
        if (queue.isEmpty()) return -1;
        
        int number = queue.poll();
        set.add(number);
        return number;
    }
    
    public boolean check(int number) {
        return !set.contains(number);
    }
    
    public void release(int number) {
        if (number > max) return;
        if (!set.contains(number)) return;
        queue.offer(number);
        set.remove(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
 