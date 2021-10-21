class SnakeGame {
    int[][] food;
    int i = 0;
    
    Queue<int[]> queue = new LinkedList<>();
    HashSet<String> set = new HashSet<>();
    int[] head = new int[]{0, 0};
    
    int score = 0;
    
    int width;
    int height;
    
    int[] rowDir = {-1, 1, 0, 0};
    int[] colDir = {0, 0, -1, 1};

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
    }
    
    public int move(String direction) {
        int dir = getDir(direction);
        int row = head[0] + rowDir[dir];
        int col = head[1] + colDir[dir];
        if (!isSafe(row, col)) return -1;
        
        if (i < food.length && row == food[i][0] && col == food[i][1]) {
            queue.offer(head);
            set.add(Integer.toString(head[0]) + "-" + Integer.toString(head[1]));
            head = new int[]{row, col};
            
            score++;
            i++;
            return score;
        }
        
        if (!queue.isEmpty()) {
            int[] tail = queue.poll();
            set.remove(Integer.toString(tail[0]) + "-" + Integer.toString(tail[1]));
            
            if (set.contains(Integer.toString(row) + "-" + Integer.toString(col))) {
                return -1;
            }
            
            queue.offer(head);
            set.add(Integer.toString(head[0]) + "-" + Integer.toString(head[1]));
        }
        
        head = new int[]{row, col};
        
        return score;
    }
    
    private boolean isSafe(int row, int col) {
        if (row < 0 || row >= height) return false;
        if (col < 0 || col >= width) return false;
        return true;
    }
    
    private int getDir(String direction) {
        switch (direction) {
            case "U" : return 0;
            case "D" : return 1;
            case "L" : return 2;
            case "R" : return 3;
        }
        return -1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
 