class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        char[] arr = s.toCharArray();
        Map<Character, Boolean> map = new HashMap<>();
        int max = 0; 
        int idx1 = 0; int idx2 = 0;
        while (idx1 < arr.length) {
            if (map.containsKey(arr[idx1])) {
                max = Math.max(idx1 - idx2, max);
                map.remove(arr[idx2]);
                idx2++;
            } else {
                map.put(arr[idx1], true);
                idx1++;
            }
        }
        max = Math.max(idx1 - idx2, max);
        return max;
    }
}

// better solution
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
