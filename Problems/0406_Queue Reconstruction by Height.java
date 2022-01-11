class Solution {
    
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        if (n == 1)
            return people;
        
        int[][] res = new int[n][2];
        
        People[] p = new People[n];
        PriorityQueue<People> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            p[i] = new People(people[i]);
            if (p[i].count == 0) {
                pq.offer(p[i]);
                p[i].count = -1;
            }
        }
        
        int idx = 0;
        while (!pq.isEmpty()) {
            People i = pq.poll();
            res[idx++] = i.data;
            
            for (int j = 0; j < n; j++) {
                if (p[j].count > 0 && p[j].height <= i.height) {
                    p[j].count--;
                }
                if (p[j].count == 0) {
                    pq.offer(p[j]);
                    p[j].count = -1;
                }
            }
        }
        
        return res;
    }
}

class People implements Comparable<People> {
    int[] data;
    int height;
    public int count;
    
    public People(int[] d) {
        data = d;
        height = data[0];
        count = data[1];
    }
    
    @Override
    public int compareTo(People p) {
        return this.height - p.height;
    }
}
