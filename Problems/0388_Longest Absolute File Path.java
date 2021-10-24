class Solution {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        
        int[] deque = new int[paths.length];
        int maxLen = 0;
        for(String path: paths){
            int lev = path.lastIndexOf("\t") + 1;
            deque[lev] = (lev > 0) ? deque[lev - 1] + 1 + path.length() - lev : path.length();
            if (path.contains(".")) maxLen = Math.max(maxLen, deque[lev]);
        }
        return maxLen;
    }
}
