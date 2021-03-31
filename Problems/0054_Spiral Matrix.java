// state machine
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length < 0 || matrix[0].length < 0)
            return new ArrayList<>();
        int row = 0, col = 0, status = 0;
        int mark = 101;
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            lst.add(matrix[row][col]);
            matrix[row][col] = mark;
            switch(status) {
                case 0:
                    if (col + 1 < matrix[0].length && matrix[row][col+1] != mark) {
                        col++;
                    } else {
                        row++;
                        status = 1;
                    }
                    break;
                case 1:
                    if (row + 1 < matrix.length && matrix[row+1][col] != mark) {
                        row++;
                    } else {
                        col--;
                        status = 2;
                    }
                    break;
                case 2:
                    if (col - 1 >= 0 && matrix[row][col-1] != mark) {
                        col--;
                    } else {
                        row--;
                        status = 3;
                    }
                    break;
                case 3:
                    if (row - 1 >= 0 && matrix[row-1][col] != mark) {
                        row--;
                    } else {
                        col++;
                        status = 0;
                    }
            }
        }
        return lst;
    }
}

