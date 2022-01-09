class Solution {
    int count = 0;
    
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        dfs(visited, 1, n);
        return count;
    }
    
    private void dfs(boolean[] visited, int pos, int n) {
        if (pos > n)
            count++;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                dfs(visited, pos + 1, n);
                visited[i] = false;
            }
        }
    }
}
