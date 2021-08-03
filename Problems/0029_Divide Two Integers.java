class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 1 || dividend == 0) return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            return 0 - dividend;
        }
        
        boolean negative;
        int quotient = 0;
        
        if (dividend > 0 && divisor > 0) {
            while (dividend >= 0) {
                dividend -= divisor;
                quotient++;
            }
            negative = false;
        } else if (dividend > 0 && divisor < 0) {
            while (dividend >= 0) {
                dividend += divisor;
                quotient++;
            }
            negative = true;
        } else if (dividend < 0 && divisor > 0) {
            while (dividend <= 0) {
                dividend += divisor;
                quotient++;
            }
            negative = true;
        } else {
            if (divisor == Integer.MIN_VALUE) {
                if (dividend == divisor) return 1;
                else return 0;
            }
            while (dividend <= 0) {
                dividend -= divisor;
                quotient++;
            }
            negative = false;
        }
        
        return negative ? 1 - quotient : quotient - 1;
    }
}

// better solution
// 可以让divisor不断成倍扩增，逼近a时作差，余数继续进行advisor的扩增作差过程，可以提高效率。
// recursion