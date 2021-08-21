class Solution {
    public void rotate(int[] nums, int k) {
        if (k == 0 || nums.length == 1) return;
        int len = nums.length;
        k = k % len;
        int num = gcd(k, len);
        for (int i = 0; i < num; i++) {
            int buf = nums[i];
            int idx = i + k;
            while (true) {
                int temp = nums[idx];
                nums[idx] = buf;
                buf = temp;
                if (idx == i) break;
                idx = (idx + k) % len;
            }
        }
    }
    
    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
