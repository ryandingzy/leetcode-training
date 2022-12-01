class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int idxMax = 0;
        int numMax = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] > numMax) {
                numMax = nums[i];
                idxMax = i;
            }
        }
        int[] nextMaxIds = new int[n];
        int[] res = new int[n];
        nextMaxIds[idxMax] = -1;
        res[idxMax] = -1;
        if (idxMax > 0) {
            for (int i = idxMax - 1; i >= 0; i--) {
                if (nums[i] == numMax) {
                    nextMaxIds[i] = -1;
                    res[i] = -1;
                    continue;
                }
                int next = i + 1;
                while (nums[next] <= nums[i]) {
                    next = nextMaxIds[next];
                }
                nextMaxIds[i] = next;
                res[i] = nums[next];
            }
        }
        if (idxMax == n - 1) {
            return res;
        }
        for (int i = n - 1; i > idxMax; i--) {
            if (nums[i] == numMax) {
                nextMaxIds[i] = -1;
                res[i] = -1;
                continue;
            }
            int next = (i + 1) % n;
            while (nums[next] <= nums[i]) {
                next = nextMaxIds[next];
            }
            nextMaxIds[i] = next;
            res[i] = nums[next];
        }
        return res;
    }
}
