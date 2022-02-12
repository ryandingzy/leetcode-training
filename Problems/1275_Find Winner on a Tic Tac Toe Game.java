class Solution {
    public String tictactoe(int[][] moves) {
        int[] rowCount = new int[3];
        int[] colCount = new int[3];
        int diag1 = 0;
        int diag2 = 0;
        int inc = 1;
        for (int i = 0; i < moves.length; i++) {
            int row = moves[i][0];
            int col = moves[i][1];
            rowCount[row] += inc;
            if (Math.abs(rowCount[row]) == 3) return inc == 1 ? "A" : "B";
            colCount[col] += inc;
            if (Math.abs(colCount[col]) == 3) return inc == 1 ? "A" : "B";
            if (row == col) {
                diag1 += inc;
                if (Math.abs(diag1) == 3) return inc == 1 ? "A" : "B";
            }
            if (row + col == 2) {
                diag2 += inc;
                if (Math.abs(diag2) == 3) return inc == 1 ? "A" : "B";
            }
            inc = 0 - inc;
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
