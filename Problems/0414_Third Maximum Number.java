class Solution {
    public int thirdMax(int[] nums) {
        int[] seq = new int[3];
        for (int i = 0; i < 3; i++) {
            seq[i] = Integer.MIN_VALUE;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            int id = 3;
            while (id > 0 && seq[id - 1] <= nums[i]) {
                id--;
            }
            if (id == 3 || nums[i] == seq[id]) {
                continue;
            }
            int val = nums[i];
            for (int j = id; j < 3; j++) {
                int tmp = seq[j];
                seq[j] = val;
                val = tmp;
            }
        }
        if (set.size() < 3) {
            return seq[0];
        } else {
            return seq[2];
        }
    }
}
