// binary search
class Solution {
    public int mySqrt(int x) {
        return (int)binarySearch(x, 0, x);
    }
    
    public long binarySearch(long x, long l, long h) {
        long mid = (l + h) / 2;
        if (mid * mid == x) {
            return mid;
        } else if (mid * mid > x) {
            if ((mid - 1) * (mid - 1) <= x) {
                return mid - 1;
            } else {
                return binarySearch(x, l, mid - 1);
            }
        } else {
            if ((mid + 1) * (mid + 1) == x) {
                return mid + 1;
            } else if ((mid + 1) * (mid + 1) > x) {
                return mid;
            } else {
                return binarySearch(x, mid + 1, h);
            }
        }
    }
}

// mathmatic solution
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}

// Newton iteration
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}
