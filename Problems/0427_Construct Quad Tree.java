/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return constructNode(grid, 0, 0, grid.length);
    }
    
    private Node constructNode(int[][] grid, int row, int col, int side) {
        if (side == 1) {
            boolean val = grid[row][col] == 1 ? true : false;
            return new Node(val, true);
        }
        // left-top
        Node lt = constructNode(grid, row, col, side / 2);
        Node lb = constructNode(grid, row + side / 2, col, side / 2);
        Node rt = constructNode(grid, row, col + side / 2, side / 2);
        Node rb = constructNode(grid, row + side / 2, col + side / 2, side / 2);
        
        if (lt.isLeaf && lb.isLeaf && rt.isLeaf && rb.isLeaf &&
            (lt.val == lb.val && lb.val == rt.val && rt.val == rb.val)) {
            return new Node(lt.val, true);
        } else {
            return new Node(true, false, lt, rt, lb, rb);
        }
    }
}
