class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0)
        {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (n == 0)
            return;
        
        int idx1 = m -1, idx2 = n-1, idx = m + n -1;
        while (idx >= 0) {
            if (idx1 < 0)  {
                while (idx >= 0)
                {
                    nums1[idx--] = nums2[idx2--];
                }
                return;
            }
            if (idx2 < 0) {
                while (idx >= 0)
                {
                    nums1[idx--] = nums1[idx1--];
                }
                return;
            }
            if (nums1[idx1] > nums2[idx2]) {
                nums1[idx--] = nums1[idx1--];  
            } else {
                nums1[idx--] = nums2[idx2--];
            }
        }
    }
}

// Shorter solution
/*
class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1;
    int p2 = n - 1;
    int p = m + n - 1;

    while ((p1 >= 0) && (p2 >= 0))
      nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

    System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
  }
}

// 最后while中如果p1 < 0了，则通过后续的复制过程可以把nums2的内容复制到nums1上去
// 如果p2 < 0了，则后续不需要进行复制了（这里注意nums原本剩余的那些就不需要处理了）
*/
