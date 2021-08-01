class Solution {
    public int reverse(int x) {
        if (x < 10 && x > -10) return x;
        
        boolean nonNegative = x >= 0;
        int res = 0;
        while (x != 0) {
            if (nonNegative) {
                if (res <= (Integer.MAX_VALUE - (double)x % 10) / 10) {
                    res = res * 10 + x % 10;
                    x /= 10;
                } else {
                    return 0;
                }
            } else {
                if (res >= (Integer.MIN_VALUE - (double)x % 10) / 10) {
                    res = res * 10 + x % 10;
                    x /= 10;
                } else {
                    return 0;
                }
            }
        }
        return res;
    }
}

// 注意
// 这里比较大小的时候，因为处10很容易把末尾的数给去掉，这里应该强转成小数格式，然后进行比较。

// better solution
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}

// 这里判断条件写成这样是可以的，因为int值最大值和最小值的最高位都是2，所以翻转之后最低位是2。另外int值的最大值末尾是7,最小值末位是8,均大于2。所以这里不需要对末位考虑。