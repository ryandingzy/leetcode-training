class Solution {
    static final int HIGHT_BIT = 30;
    
    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for (int k = HIGHT_BIT; k  >= 0; --k) {
            Set<Integer> seen = new HashSet<>();
            
            for (int num : nums) {
                seen.add(num >> k);
            }
            
            int xNext = x << 1 + 1;
            boolean found = false;
            for (int num : nums) {
                if (seen.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }
            
            if (found) {
                x = xNext;
            } else {
                x = xNext - 1;
            }
        }
        return x;
    }
}

// x = a XOR b
// b = a XOR x

// x = 1011 XOR all prefix of a


// T(n) = O(nloga)

// Trie
class Solution {
    class Trie {
        Trie left = null;
        Trie right = null;
    }
    
    Trie root = new Trie();
    static final int HIGH_BIT = 30;
    
    public int findMaximumXOR(int[] nums) { // nums[3, 10, 5]
        int n = nums.length; // 3
        int x = 0;
        for (int i = 1; i < n; i++) {
            add(nums[i - 1]); // 3
            x = Math.max(x, check(nums[i]));
        }
        return x;
    }
    
    public void add(int num) {
        Trie cur = root;
        for (int k = HIGH_BIT; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                if (cur.left == null) {
                    cur.left = new Trie();
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new Trie();
                }
                cur = cur.right;
            }
        }
    }
    
    public int check(int num) {
        Trie cur = root;
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                // the kth bit of ai is 0, then b should be 1 in this bit
                if (cur.right != null) {
                    cur = cur.right;
                    x = x << 1 + 1;
                } else {
                    cur = cur.left;
                    x = x << 1;
                }
            } else {
                // the kth bit of ai is 1, then b should be 0 in this bit
                if (cur.left != null) {
                    cur = cur.left;
                    x = x << 1 + 1;
                } else {
                    cur = cur.right;
                    x = x << 1;
                }
            }
        }
        return x;
    }
}

// nums[3, 10, 5]