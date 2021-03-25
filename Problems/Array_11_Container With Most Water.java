class Solution {
    public int maxArea(int[] height) {
        int idx1 = 0, idx2 = height.length - 1;
        int sum = 0;
        while (idx2 >= idx1) {
            if (height[idx1] < height[idx2]) {
                sum = Math.max(sum, height[idx1] * (idx2 - idx1));
                idx1++;
            } else {
                sum = Math.max(sum, height[idx2] * (idx2 - idx1));
                idx2--;
            }
        }
        return sum;
    }
}
