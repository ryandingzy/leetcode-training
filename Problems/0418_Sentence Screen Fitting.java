// My method, TLE
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;

        int count = 1;
        int space = cols;
        int i = 0;
        int times = 1;
        while (count <= rows) {
            if (sentence[i].length() > cols) {
                return 0;
            } else if (sentence[i].length() > space) {
                count++;
                space = cols - sentence[i].length() - 1;
            } else if (sentence[i].length() < space) {
                space -= sentence[i].length() + 1;
            } else {
                space = 0;
                if (i == n - 1) {
                    times = rows / count * times;
                    count = rows / count * count;
                }
            }
            if (i == n - 1) {
                times++;
                i = 0;
            } else {
                i++;
            }
        }
        if (i == 0) {
            times -= 1;
        }
        return times - 1;
    }
}


// Butter solution
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }
        
        return start / s.length();
    }
}
