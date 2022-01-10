class Solution {
    public boolean validWordSquare(List<String> words) {
        int n = 0;
        for (int i = 0; i < words.size(); i++) {
            n = Math.max(n, words.get(i).length());
        }
        n = Math.max(n, words.size());
        char[][] arr = new char[n][n];
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                arr[i][j] = words.get(i).charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
