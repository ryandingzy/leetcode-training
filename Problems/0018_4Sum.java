// Wrong solution
/*
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lsts = new ArrayList<>();
        if (nums.length < 4) {
            return lsts;
        }
        Arrays.sort(nums);
        int a = 0, d = nums.length - 1;
        int b, c;
        int sum，diff;
        while (a + 2 < d) {
            if (a > 0 && nums[a] == nums[a-1]) {
                a++;
                continue;
            }
            if (d < nums.length - 1 && nums[d] == nums[d+1]) {
                d--;
                continue;
            }
            b = a + 1;
            c = d - 1;
            while (b < c) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    b++;
                    continue;
                }
                if (c < d - 1 && nums[c] == nums[c + 1]) {
                    c--;
                    continue;
                }
                sum = nums[a] + nums[b] + nums[c] + nums[d];
                diff = sum - target;
                if (diff == 0) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(a); lst.add(b); lst.add(c); lst.add(d);
                    lsts.add(lst);
                    b++;
                    c--;
                } else if (diff < 0) {
                    b++;
                } else if (diff > 0) {
                    c--;
                }
            }
        }
        return lsts;
    }
}
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lsts = new ArrayList<>();
        if (nums.length < 4) {
            return lsts;
        }
        Arrays.sort(nums);
        int a, b, c, d;
        int sum, diff;
        for (a = 0; a <= nums.length - 4; a++) {
            if (a > 0 && nums[a] == nums[a - 1])
                continue;
            for (b = a + 1; b <= nums.length - 3; b++) {
                if (b > a + 1 && nums[b] == nums[b-1])
                    continue;
                c = b + 1;
                d = nums.length - 1;
                while (c < d) {
                    if (c > b + 1 && nums[c] == nums[c-1]) {
                        c++;
                        continue;
                    }
                    if (d < nums.length - 1 && nums[d] == nums[d+1]) {
                        d--;
                        continue;
                    }
                    sum = nums[a] + nums[b] + nums[c] + nums[d];
                    diff = sum - target;
                    if (diff == 0) {
                        List<Integer> lst = new ArrayList<>();
                        lst.add(nums[a]); lst.add(nums[b]); lst.add(nums[c]); lst.add(nums[d]);
                        lsts.add(lst);
                        c++;
                        d--;
                    } else if (diff < 0) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        }        
        return lsts;
    }
}

