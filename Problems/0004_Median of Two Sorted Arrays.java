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
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            
            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
*/
