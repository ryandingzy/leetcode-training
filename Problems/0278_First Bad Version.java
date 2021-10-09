/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return binarySearch(1, n);
    }
    
    public int binarySearch(int left, int right) {
        if (left == right) return left;
        if (left + 1 == right) return isBadVersion(left) ? left : right;
        int mid = (int)(((long)left + right) / 2);
        if (isBadVersion(mid)) {
            return binarySearch(left, mid);
        } else {
            return binarySearch(mid + 1, right);
        }
    }
}
