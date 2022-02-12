class Solution {
    public int minSwaps(int[] data) {
        // traverse
        int count = 0;
        for (int i : data) {
            if (i == 1) count++;
        }
        int left = 0, right = 0;
        int move = 0;
        while (right < count) {
            if (data[right] == 0) move++;
            right++;
        }
        int min = move;
        int len = data.length;
        while (right < len) {
            if (data[right] == 0) {
                move++;
            }
            if (data[left] == 0) {
                move--;
            }
            min = Math.min(min, move);
            right++;
            left++;
        }
        return min;
    }
}
