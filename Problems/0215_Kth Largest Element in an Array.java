class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = heap.poll();
        }
        return res;
    }
}
