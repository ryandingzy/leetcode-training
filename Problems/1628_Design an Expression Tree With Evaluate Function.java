/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class NumberNode extends Node {
    int val;
    public NumberNode(int value) {
        val = value;
    }
    
    @Override
    public int evaluate() {
        return val;
    }
};

class OperatorNode extends Node {
    public OperatorNode(String opt) {
        operator = opt;
    }
    String operator;
    Node left;
    Node right;
    
    @Override
    public int evaluate() {
        return cal(left.evaluate(), right.evaluate());
    }
    
    public int cal(int n1, int n2) {
        if (operator.equals("+")) {
            return n1 + n2;
        }
        if (operator.equals("-")) {
            return n1 - n2;
        }
        if (operator.equals("*")) {
            return n1 * n2;
        }
        if (operator.equals("/")) {
            return n1 / n2;
        }
        return 0;
    }
};

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    
    private static boolean isOperator(String str) {
        if (str.charAt(0) <= '9' && str.charAt(0) >= '0') return false;
        return true;
    }
    
    Node buildTree(String[] postfix) {
        Deque<Node> stack = new ArrayDeque<>();
        for (String curValue : postfix) {
            if (isOperator(curValue)) {
                OperatorNode node = new OperatorNode(curValue);
                node.right = stack.pollLast();
                node.left = stack.pollLast();
                stack.addLast(node);
            } else {
                stack.addLast(new NumberNode(Integer.valueOf(curValue)));
            }
        }
        return stack.pollLast();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
 