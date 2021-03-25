public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Integer index2 = new Integer(0);
        for (int i = 0; i < nums.length; i++) {
            Pair<Boolean, Integer> p = isContain(target - nums[i], nums, i);
            if (p.getKey()) {
                return new int[] {i, p.getValue()};
            }
        }
        return new int[] {0, 1};
    }

    public Pair<Boolean, Integer> isContain(int num, int[] nums, int index)
    {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num && index != i) {
                return new Pair<Boolean, Integer>(true, i);
            }
        }
        return new Pair<Boolean, Integer>(false, 0);
    }
}


// better solution
/*
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}
*/
