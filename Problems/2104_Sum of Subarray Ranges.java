class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        int n = nums.length;
        Deque<Integer> min = new ArrayDeque<Integer>();
        Deque<Integer> max = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while (!min.isEmpty() && nums[i] <= nums[min.peekLast()]) {
                int id = min.pollLast();
                int left = min.isEmpty() ? -1 : min.peekLast();
                sum -= (long)(id - left) * (i - id) * nums[id];
            }
            while (!max.isEmpty() && nums[i] >= nums[max.peekLast()]) {
                int id = max.pollLast();
                int left = max.isEmpty() ? -1 : max.peekLast();
                sum += (long)(id -left) * (i - id) * nums[id];
            }
            min.addLast(i);
            max.addLast(i);
        }
        while (!min.isEmpty()) {
            int id = min.pollLast();
            int left = min.isEmpty() ? -1 : min.peekLast();
            sum -= (long)(id - left) * (n - id) * nums[id];
        }
        while (!max.isEmpty()) {
            int id = max.pollLast();
            int left = max.isEmpty() ? -1 : max.peekLast();
            sum += (long)(id - left) * (n - id) * nums[id];
        }
        return sum;
    }
}
