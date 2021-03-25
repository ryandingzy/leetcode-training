class Solution {
    public int[] plusOne(int[] digits) {
        int add = 1;
        for (int i = digits.length -1; i >= 0; i--) {
            if (digits[i] + add >= 10) {
                digits[i] = (digits[i] + add) % 10;
                add = 1;
            } else {
                digits[i] = digits[i] + add;
                add = 0;
            }
        }
        if (add == 1) {
            int[] newDigits = new int[digits.length + 1];
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            newDigits[0] = 1;
            return newDigits;
        }
        else {
            return digits;
        }
    }
}

// better solution
/*
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits; // 对于99,999这种，没有必要对后面进行copy了，直接最高位给1就好了。
    }
}
*/