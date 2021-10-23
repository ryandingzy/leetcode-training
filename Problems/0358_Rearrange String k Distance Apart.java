class Solution {
    public String rearrangeString(String s, int k) {
        if(k == 0) return s;
        Map<Character, Integer> map = new HashMap<>();
        
        for(Character c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        PriorityQueue<Character> heap = new PriorityQueue<>((c1, c2) -> map.get(c2).compareTo(map.get(c1)));        
        heap.addAll(map.keySet());
        
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        
        while(!heap.isEmpty()){            
            char c = heap.poll();
            queue.add(c);
            map.put(c, map.get(c) - 1);
            sb.append(c);

			// Characters are added back in the heap in the order they were removed
			// Whenever all the instances of a particular char is exhausted, then the heap size is reduced as it is not added back in the heap
            if (queue.size() >= k) {
                char ch = queue.poll();
                if(map.get(ch) > 0)
                    heap.add(ch);                
            }            
        }        
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
