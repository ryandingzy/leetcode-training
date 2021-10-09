class Solution {
    public int hIndex(int[] citations) {
        return binarySearch(citations, 0, citations.length - 1);
    }
    
    public int binarySearch(int[] citations, int left, int right) {
        int n = citations.length;
        if (left >= right) {
            if (citations[left] >= n - left) return n - left;
            else return n - left - 1;
        }
        int mid = (left + right) / 2;
        if (citations[mid] >= n - mid) {
            return binarySearch(citations, left, mid - 1);
        } else {
            return binarySearch(citations, mid + 1, right);
        }
    }
}
