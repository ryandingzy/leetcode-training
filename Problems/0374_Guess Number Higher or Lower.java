/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return binarySearch(0, n);
    }
    
    public int binarySearch(int left, int right) {
        if (left >= right - 1) {
            return guess(left) == 0 ? left : right;
        }
        int mid = (right - left) / 2 + left;
        int guess = guess(mid);
        if (guess == 0) return mid;
        if (guess == -1) return binarySearch(left, mid - 1);
        return binarySearch(mid + 1, right);
    }
}
