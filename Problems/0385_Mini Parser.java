/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        return deserialize(s, 0, s.length() - 1);
    }
    
    private NestedInteger deserialize(String s, int l, int r) {
        if (s.charAt(l) != '[') {
            NestedInteger ni = new NestedInteger(Integer.valueOf(s.substring(l, r + 1)));
            return ni;
        }
        NestedInteger ni = new NestedInteger();
        int ll = l + 1;
        while (ll < r) {
            if (s.charAt(ll) == ',') {
                ll++;
                continue;
            }
            int rr = findItem(s, ll);
            ni.add(deserialize(s, ll, rr));
            ll = rr + 1;
        }
        return ni;
    }
    
    private int findItem(String s, int l) {
        if (s.charAt(l) != '[') {
            int res = l + 1;
            while (res < s.length() && s.charAt(res) != ',' && s.charAt(res) != ']')
                res++;
            return res - 1;
        }
        int count = 1;
        int res = l + 1;
        while (res < s.length()) {
            if (s.charAt(res) == '[') {
                count++;
            } else if (s.charAt(res) == ']') {
                count--;
                if (count == 0)
                    return res;
            }
            res++;
        }
        return res - 1;
    }
}
