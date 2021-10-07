class Vector2D {
    int[][] vector;
    int row = 0;
    int col = 0;

    public Vector2D(int[][] vec) {
        vector = vec;
        while (row < vector.length && vector[row].length == 0) row++;
    }
    
    public int next() {
        int res = vector[row][col];
        if (col == vector[row].length - 1) {
            row++;
            while (row < vector.length && vector[row].length == 0) row++;
            col = 0;
        } else {
            col++;
        }
        return res;
    }
    
    public boolean hasNext() {
        return row < vector.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
 