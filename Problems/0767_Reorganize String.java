class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                heap.offer(new int[]{i, count[i]});
            }
        }
        if (heap.peek()[1] > (s.length() + 1) / 2)
            return "";
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            int[] num;
            if (sb.length() != 0 && sb.charAt(sb.length() - 1) - 'a' == heap.peek()[0]) {
                int[] tmp = heap.poll();
                num = heap.poll();
                heap.offer(tmp);
            } else {
                num = heap.poll();
            }
            sb.append((char)('a' + num[0]));
            if (num[1] != 1) {
                num[1]--;
                heap.offer(num);
            }
        }
        return sb.toString();
    }
}
