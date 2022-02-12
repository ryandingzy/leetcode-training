class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int stick : sticks) {
            heap.offer(stick);
        }
        
        int cost = 0;
        while (heap.size() > 1) {
            int s1 = heap.poll();
            int s2 = heap.poll();
            int s = s1 + s2;
            cost += s;
            heap.offer(s);
        }
        return cost;
    }
}
