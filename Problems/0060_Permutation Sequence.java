class Solution {
    public String getPermutation(int n, int k) {
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i + 1;
        }
        
        for (int i = 2; i <= k; i++) {
            for (int j = n - 2; j >= 0; j--) {
                if (num[j] < num[j+1]) {
                    int idx = j+1, ii = j+2;
                    while (ii < n) {
                        if (num[ii] > num[j])
                            idx = ii;
                        ii++;
                    }
                    int temp = num[j];
                    num[j] = num[idx];
                    num[idx] = temp;
                    Arrays.sort(num, j + 1, n);
                    break;
                }
            }
        }
        // Convert to String
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((char)(num[i] + '0'));
        }
        return sb.toString();
    }
}

// Better solution
class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }
}

