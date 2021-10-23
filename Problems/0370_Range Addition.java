class Solution {
    public int[] getModifiedArray(int l, int[][] updates) {
        
        int[] ans = new int[l];
        
        for (int[] q : updates) {
            int s = q[0]; // start
            int e = q[1]; // end
            int v = q[2]; // value
            
            ans[s] += v;
            if (e < l-1)
                ans[e+1] -= v; // to nullify the effect of start exclusive of the end.
        }
        
        for (int i = 1; i < l; i++)
         ans[i] += ans[i-1]; // finally updating all values with answers
        
        return ans;
    }
}
