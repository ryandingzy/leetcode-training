class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return verify(preorder, 0, preorder.length - 1);
    }
    
    public boolean verify(int[] preorder, int start, int end) {
        if (start + 1 >= end) return true;
        int num = preorder[start];
        boolean isRight = false;
        int leftEnd = start;
        for (int i = start + 1; i <= end; i++) {
            if (preorder[i] > num) {
                if (!isRight) {
                    leftEnd = i - 1;
                    isRight = true;
                }
            } else {
                if (isRight) {
                    return false;
                }
            }
        }
        if (leftEnd > start + 2) {
            if (!verify(preorder, start + 1, leftEnd)) return false;
        }
        if (end > leftEnd + 2) {
            if (!verify(preorder, leftEnd + 1, end)) return false;
        }
        return true;
    }
}
