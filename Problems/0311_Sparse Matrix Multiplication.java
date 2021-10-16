// basic method
class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat2.length;
        int n = mat2[0].length;
        int[][] res = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                for (int i = 0; i < k; i++) {
                    res[row][col] += mat1[row][i] * mat2[i][col];
                }
            }
        }
        return res;
    }
}

// better solution -- by myself
class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat2.length;
        int n = mat2[0].length;
        int[][] res = new int[m][n];
        HashMap<Integer, List<int[]>> map1 = new HashMap<>();
        HashMap<Integer, List<int[]>> map2 = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                if (mat1[i][j] != 0) {
                    if (!map1.containsKey(i)) {
                        map1.put(i, new ArrayList<int[]>());
                    }
                    map1.get(i).add(new int[] {j, mat1[i][j]});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (mat2[j][i] != 0) {
                    if (!map2.containsKey(j)) {
                        map2.put(j, new ArrayList<int[]>());
                    }
                    map2.get(j).add(new int[]{i, mat2[j][i]});
                }
            }
        }
        for (Map.Entry<Integer, List<int[]>> entry : map1.entrySet()) {
            for (int[] num1 : entry.getValue()) {
                if (map2.containsKey(num1[0])) {
                    for (int[] num2 : map2.get(num1[0])) {
                        res[entry.getKey()][num2[0]] += num1[1] * num2[1];
                    }
                }
            }
        }
        return res;
    }
}
