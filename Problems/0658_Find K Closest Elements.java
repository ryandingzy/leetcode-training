class Solution {

    private int binarySearch(int[] arr, int left, int right, int x) {
        if (right == left) return left;
        if (left + 1 == right) {
            int leftDiff = Math.abs(arr[left] - x);
            int rightDiff = Math.abs(arr[right] - x);
            if (leftDiff > rightDiff) return right;
            else return left;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == x) return mid;
        else if (arr[mid] > x) return binarySearch(arr, left, mid, x);
        else return binarySearch(arr, mid, right, x);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int bestId = binarySearch(arr, 0, n - 1, x);
        int l = bestId;
        int r = bestId;
        while (r - l + 1 < k) {
            if (l == 0) {
                r++;
                continue;
            }
            if (r == n - 1) {
                l--;
                continue;
            }
            int leftDiff = Math.abs(arr[l-1] - x);
            int rightDiff = Math.abs(arr[r+1] - x);
            if (leftDiff > rightDiff) {
                r++;
            } else {
                l--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
