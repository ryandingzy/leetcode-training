/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        char[] buf4 = new char[4];
        int count4 = 0;
        while (true) {
            count4 = read4(buf4);
            int i = 0;
            for (; i < count4 && count + i < n; i++) {
                sb.append(buf4[i]);
            }
            count += i;
            if (count == n) break;
            if (count4 < 4) break;
        }
        sb.getChars(0, sb.length(), buf, 0);
        return count;
    }
}

// 数组是够大的可以直接往数组里写
public class Solution extends Reader4 {
    public int read(char[] buf, int n) {
        int copiedChars = 0, readChars = 4;
        char[] buf4 = new char[4];
        
        while (copiedChars < n && readChars == 4) {
            readChars = read4(buf4);
            
            for (int i = 0; i < readChars; ++i) {
                if (copiedChars == n)
                    return copiedChars;
                buf[copiedChars] = buf4[i];
                ++copiedChars;    
            }    
        }
        return copiedChars;
    }
}