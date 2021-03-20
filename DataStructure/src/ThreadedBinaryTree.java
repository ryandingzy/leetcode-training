public class ThreadedBinaryTree {
    private TBTNode root;

    private TBTNode pre = null;

    public void setRoot(TBTNode root)
    {
        this.root = root;
    }

    /**
     *
     * @param node the node to be threaded
     */
    public void threadedNodes(TBTNode node) {
        if (node == null) {
            return;
        }
        threadedNodes(node.getLeft());
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(true);
        }
        if (pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(true);
        }
        pre = node;
        threadedNodes(node.getRight());
    }
}

class TBTNode {
    private int id;
    private int data;
    private TBTNode left;
    private TBTNode right;

    // false--child, true--pre
    private boolean leftType;
    // false--child, true--post
    private boolean rightType;

    public TBTNode(int id, int data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TBTNode getLeft() {
        return left;
    }

    public void setLeft(TBTNode left) {
        this.left = left;
    }

    public TBTNode getRight() {
        return right;
    }

    public void setRight(TBTNode right) {
        this.right = right;
    }

    public boolean isLeftType() {
        return leftType;
    }

    public void setLeftType(boolean leftType) {
        this.leftType = leftType;
    }

    public boolean isRightType() {
        return rightType;
    }

    public void setRightType(boolean rightType) {
        this.rightType = rightType;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) this.left.preOrder();
        if (this.right != null) this.right.preOrder();
    }

    public void infixOrder() {
        if (this.left != null) this.left.infixOrder();
        System.out.println(this);
        if (this.right != null) this.right.infixOrder();
    }

    public void postOrder() {
        if (this.left != null) this.left.postOrder();
        if (this.right != null) this.right.postOrder();
        System.out.println(this);
    }

    // search
    public TBTNode preOrderSearch(int id) {
        if (this.id == id) {
            return this;
        }

        TBTNode res = null;
        // left
        if (this.left != null) {
            res = this.left.preOrderSearch(id);
        }
        if (res != null) {
            return res;
        }

        // right
        if (this.right != null) {
            res = this.right.preOrderSearch(id);
        }
        return res;
    }

    // delete node or tree
    public boolean delNode(int id) {
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return true;
        }
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return true;
        }
        if (this.left != null) {
            boolean res = this.left.delNode(id);
            if (res) return true;
        }
        if (this.right != null) {
            boolean res = this.right.delNode(id);
            if (res) return true;
        }
        return false;
    }
}
