class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] chars = new char[2];
        int[][] pos = new int[2][2];
        chars[0] = s.charAt(0);
        pos[0][0] = 0;
        pos[0][1] = 0;
        int count = 1;
        int i;
        for (i = 1; i < s.length(); i++) {
            if (s.charAt(i) == chars[0]) {
                pos[0][1] = i;
                count++;
            } else {
                chars[1] = s.charAt(i);
                pos[1][0] = i;
                pos[1][1] = i;
                count++;
                break;
            }
        }
        i++;
        int max = count;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == chars[0]) {
                pos[0][1] = i;
                count++;
                max = Math.max(max, count);
            } else if (s.charAt(i) == chars[1]) {
                pos[1][1] = i;
                count++;
                max = Math.max(max, count);
            } else {
                int j = pos[0][1] < pos[1][1] ? 0 : 1;
                pos[1-j][0] = pos[j][1] + 1;
                count = pos[1-j][1] - pos[1-j][0] + 2;
                chars[j] = s.charAt(i);
                pos[j][0] = i;
                pos[j][1] = i;
            }
        }
        return max;
    }
}

// better solution
// 这里涉及到去除map中value值小的那个map
class Solution {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int n = s.length();
    if (n < 3) return n;

    // sliding window left and right pointers
    int left = 0;
    int right = 0;
    // hashmap character -> its rightmost position
    // in the sliding window
    HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

    int max_len = 2;

    while (right < n) {
      // when the slidewindow contains less than 3 characters
      hashmap.put(s.charAt(right), right++);

      // slidewindow contains 3 characters
      if (hashmap.size() == 3) {
        // delete the leftmost character
        int del_idx = Collections.min(hashmap.values());
        hashmap.remove(s.charAt(del_idx));
        // move left pointer of the slidewindow
        left = del_idx + 1;
      }

      max_len = Math.max(max_len, right - left);
    }
    return max_len;
  }
}
