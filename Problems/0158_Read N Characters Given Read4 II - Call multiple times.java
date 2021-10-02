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
    int index = 4;
    char[] buf4 = new char[4];
    int bound = 4;
    
    public int read(char[] buf, int n) {
        
        int count = 0;
        while (count < n) {
            if (index == bound) {
                if (bound < 4) return count;
                else {
                    bound = read4(buf4);
                    index = 0;
                }
            } else {
                buf[count++] = buf4[index++];
            }
        }
        return count;
    }
}
