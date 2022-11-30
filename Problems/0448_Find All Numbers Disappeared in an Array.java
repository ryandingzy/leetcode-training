class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int jump = nums[0] - 1;
        int move = 0;
        nums[0] = -1;
        while (move < nums.length) {
            if (nums[jump] <= 0) {
                nums[jump] = 0;
                move++;
                while (move < nums.length && nums[move] <= 0) {
                    move++;
                }
                if (move == nums.length) break;
                jump = nums[move] - 1;
                nums[move] = -1;
            } else {
                int tmp = nums[jump];
                nums[jump] = 0;
                jump = tmp - 1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
