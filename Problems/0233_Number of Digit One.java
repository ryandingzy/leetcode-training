class Solution {
    public int countDigitOne(int n) {
        int i = 1;
        int count = 0;
        while (n >= i) {
            count += n / (i * 10) * i;
            int part = n % (i * 10);
            if (part >= i) count += part >= i + i ? i : part - i + 1;
            i *= 10;
        }
        return count;
    }
}
