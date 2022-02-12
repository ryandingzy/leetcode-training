class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(entry);
        }
        while (k > 0) {
            Map.Entry<Integer, Integer> entry = heap.poll();
            if (entry.getValue() > k)
                return heap.size() + 1;;
            k -= entry.getValue();
        }
        return heap.size();
    }
}
