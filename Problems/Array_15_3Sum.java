class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lstRst = new ArrayList<>();
        if (nums.length < 3)
            return lstRst;
        
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int l = i + 1, r = nums.length -1;
            while (l < r)
            {
                if (l > i + 1 && nums[l] == nums[l-1])
                {
                    l++;
                    continue;
                }
                if (r < nums.length - 1 && nums[r] == nums[r+1])
                {
                    r--;
                    continue;
                }
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> lstSingle = new ArrayList<>();
                    lstSingle.add(nums[i]);
                    lstSingle.add(nums[l]);
                    lstSingle.add(nums[r]);
                    lstRst.add(lstSingle);
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return lstRst;
    }
}

// better solution
/*
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for(int i = 0;i < len;++i) {
            if(nums[i] > 0) return lists;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int curr = nums[i];
            int L = i+1, R = len-1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if(tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }
*/