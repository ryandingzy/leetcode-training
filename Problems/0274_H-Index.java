class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count = 1;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] < count) return count - 1;
            count++;
        }
        return citations.length;
    }
}
