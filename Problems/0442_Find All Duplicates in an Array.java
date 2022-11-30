class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int cur = nums[0] - 1;
        nums[0] = -1;
        int pre = 0;
        int n = nums.length;
        int count = 0;
        while (count <= n) {
            if (nums[cur] <= 0) {
                if (nums[cur] == 0) {
                    res.add(cur + 1);
                }
                nums[cur] = 0;
                do {
                    pre++;
                } while (pre < n && nums[pre] == 0);
                if (pre == n) return res;
                cur = nums[pre] - 1;
                nums[pre] = -1;
            } else {
                int tmp = nums[cur];
                nums[cur] = 0;
                cur = tmp - 1;
            }
            count++;
        }
        return res;
    }
}
