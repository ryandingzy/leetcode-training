class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer("");
        
        int idx = 0;
        char cur = '\0'; // 这里注意都要进行初始化
        while (true) {
            for (int i = 0; i < strs.length; i++) {
                if (idx < strs[i].length()) {
                    if (i == 0) {
                        cur = strs[i].charAt(idx);
                    } else {
                        if (strs[i].charAt(idx) != cur) {
                            return sb.toString();
                        }
                    }
                } else {
                    return sb.toString();
                }
            }
            sb.append(cur);
            idx++;
        }
    }
}