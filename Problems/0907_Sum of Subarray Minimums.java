class Solution {
    public int sumSubarrayMins(int[] A) {
        int MOD = 1000000007;
        
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peekLast()] > A[i]) {
                int idx = stack.pollLast();
                int left, right;
                if (stack.isEmpty()) {
                    left = idx + 1;
                } else {
                    left = idx - stack.peekLast();
                }
                right = i - idx;
                count += (int)(((long)left * right * A[idx]) % MOD);
                count %= MOD;
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.pollLast();
            int left, right;
            if (stack.isEmpty()) {
                left = idx + 1;
            } else {
                left = idx - stack.peekLast();
            }
            right = n - idx;
            count += (int)(((long)left * right * A[idx]) % MOD);
            count %= MOD;
        }
        return count;
    }
}
