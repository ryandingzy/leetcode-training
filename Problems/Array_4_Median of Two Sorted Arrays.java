class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int idx1 = 0;
        int idx2 = 0;
        int idx = 0;
        int[] nums = new int[nums1.length + nums2.length];
        if (nums1.length == 0) 
            nums = nums2;
        else if (nums2.length == 0)
            nums = nums1;
        else {
            while (true) {
            if (nums1[idx1] <= nums2[idx2]) {
                nums[idx++] = nums1[idx1++];
            } else {
                nums[idx++] = nums2[idx2++];
            }
            if (idx1 >= nums1.length) {
                while (idx2 < nums2.length) {
                    nums[idx++] = nums2[idx2++];
                }
                break;
            }
            if (idx2 >= nums2.length) {
                while (idx1 < nums1.length) {
                    nums[idx++] = nums1[idx1++];
                }
                break;
            }
        }
        }
        if (nums.length % 2 == 1) {
            return (double)nums[nums.length / 2];
        } else {
            return ((double)nums[nums.length / 2 - 1] + (double)nums[nums.length / 2]) / 2;
        }
    }
}

// better solution
/*
class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
*/
