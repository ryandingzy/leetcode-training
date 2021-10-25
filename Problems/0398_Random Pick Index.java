class Solution {
    HashMap<Integer, List<Integer>> map;
    Random rd;

    public Solution(int[] nums) {
        map = new HashMap<>();
        rd = new Random();
        
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<Integer>());
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> indexs = map.get(target);
        
        return indexs.get(rd.nextInt(indexs.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
 