class Solution {
    public int[] findDiagonalOrder(int[][] mat) { // [[1,2],[3,4]]
        int c = 0;
        int r = 0;
        int m = mat.length; // 2
        int n = mat[0].length; // 2
        
        int[] res = new int[m * n]; // 4
        int count = 0;
        
        // 1 -- true, 2 -- false
        boolean state = true; // true
        while (c != n - 1 || r != m - 1) { // [1, 1]
            res[count++] = mat[r][c]; // res = [1, 2, 3, ]
            if (state) {
                // state 1
                if (r == 0 || c == n - 1) { 
                    if (c == n - 1) {
                        r += 1;
                    } else {
                        c += 1;
                    }
                    state = !state;
                } else {
                    r -= 1;
                    c += 1;
                }
            } else {
                // state 2
                if (c == 0 || r == m - 1) {
                    if (r == m - 1) {
                        c += 1;
                    } else {
                        r += 1;
                    }
                    state = !state;
                } else {
                    r += 1;
                    c -= 1;
                }
            }
        }
        res[count] = mat[r][c];
        
        return res;
    }
}

// state 1  1.1  if r == 0 || c == n - 1=> state 2 (r, c + 1) | (r + 1, c)
//               else move to next  state 1

// state 2 if c == 0|| r == m - 1 => state 1 (r + 1, c) | (r, c + 1)
//         else move to next state 2


// test1
// [[1,2],[3,4]]
