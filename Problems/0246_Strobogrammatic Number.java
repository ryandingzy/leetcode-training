class Solution {
    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            char leftNum = num.charAt(left);
            char rightNum = num.charAt(right);
            if (leftNum == '0' || leftNum == '1' || leftNum == '8') {
                if (rightNum != leftNum) return false;
            } else if (leftNum == '6' || leftNum == '9') {
                if (rightNum != (char)(15 - (leftNum - '0') + '0')) return false;
            } else return false;
            left++;
            right--;
        }
        return true;
    }
}
