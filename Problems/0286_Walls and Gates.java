class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    count++;
                }
            }
        }
        int distance = 1;
        int next = 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            count--;
            if (pos[1] - 1 >= 0 && rooms[pos[0]][pos[1]-1] == Integer.MAX_VALUE) {
                rooms[pos[0]][pos[1]-1] = distance;
                queue.offer(new int[]{pos[0], pos[1]-1});
                next++;
            }
            if (pos[1] + 1 < n && rooms[pos[0]][pos[1]+1] == Integer.MAX_VALUE) {
                rooms[pos[0]][pos[1]+1] = distance;
                queue.offer(new int[]{pos[0], pos[1]+1});
                next++;
            }
            if (pos[0] - 1 >= 0 && rooms[pos[0]-1][pos[1]] == Integer.MAX_VALUE) {
                rooms[pos[0]-1][pos[1]] = distance;
                queue.offer(new int[]{pos[0]-1, pos[1]});
                next++;
            }
            if (pos[0] + 1 < m && rooms[pos[0]+1][pos[1]] == Integer.MAX_VALUE) {
                rooms[pos[0]+1][pos[1]] = distance;
                queue.offer(new int[]{pos[0]+1, pos[1]});
                next++;
            }
            if (count == 0) {
                count = next;
                next = 0;
                distance++;
            }
        }
    }
}
