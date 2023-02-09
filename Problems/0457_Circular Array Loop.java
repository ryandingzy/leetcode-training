class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        if (n == 1) return false;
        Set<Integer> invalid = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (invalid.contains(i)) continue;
            Set<Integer> visited = new HashSet<>();
            boolean positive = nums[i] > 0;
            int cur = i;
            while (true) {
                if (positive ^ (nums[cur] > 0)) {
                    for (int v : visited) {
                        invalid.add(v);
                    }
                    break;
                } else {
                    if (visited.contains(cur)) {
                        if (nums[cur] % n != 0) return true; 
                        else {
                            for (int v : visited) {
                                invalid.add(v);
                            }
                            break;
                        }
                    } else {
                        visited.add(cur);
                        cur = (cur + nums[cur] % n + n) % n;
                    }
                }
            }
        }
        return false;
    }
}
