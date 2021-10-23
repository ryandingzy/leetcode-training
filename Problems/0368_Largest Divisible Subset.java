// dfs -- TLE
class Solution {
    List<Integer> res = new ArrayList<>();
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
        return res;
    }
    
    public void dfs(int[] nums, int start, List<Integer> temp) {
        if (start == nums.length) {
            if (temp.size() > res.size()) {
                res = new ArrayList<Integer>(temp);
            }
        }
        for (int i = start; i < nums.length; i++) {
            int j = 0;
            for (; j < temp.size(); j++) {
                if (nums[i] % temp.get(j) != 0)
                    break;
            }
            if (j == temp.size()) {
                temp.add(nums[i]);
                if (temp.size() > res.size()) {
                    res = new ArrayList<Integer>(temp);
                }
                dfs(nums, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

// dynamic programming
class Solution {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    // Test case with empty set.
    int n = nums.length;
    if (n == 0) return new ArrayList();
        
    // Container to keep the largest divisible subset
    //   that ends with each of the nums.
    List<ArrayList> EDS = new ArrayList();
    for (int num : nums) EDS.add(new ArrayList());

    /* Sort the original list in ascending order. */
    Arrays.sort(nums);

    /* Calculate all the values of EDS(X_i) */
    for (int i = 0; i < n; ++i) {
      List<Integer> maxSubset = new ArrayList();
            
      // Find the largest divisible subset of previous elements.
      for (int k = 0; k < i; ++k) 
        if (nums[i] % nums[k] == 0 && maxSubset.size() < EDS.get(k).size())
          maxSubset = EDS.get(k);
          
      // Extend the found subset with the element itself.
      EDS.get(i).addAll(maxSubset);
      EDS.get(i).add(nums[i]);
    }
    /* Find the largest of EDS values  */
    List<Integer> ret = new ArrayList();
    for (int i = 0; i < n; ++i) 
      if (ret.size() < EDS.get(i).size()) ret = EDS.get(i);
    return ret;
  }  
}
