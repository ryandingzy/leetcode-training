class Solution {
    private List<Character> numberToChar(int num) {
        List<Character> res = new ArrayList<>();
        while (num > 0) {
            res.add((char)('0' + (num % 10)));
            num /= 10;
        }
        Collections.reverse(res);
        return res;
    }

    public int compress(char[] chars) {
        int l = 0;
        int r = 0;
        int id = 0;
        while (r < chars.length) {
            if (chars[l] == chars[r]) {
                r++;
            } else {
                if (r == l + 1) {
                    chars[id] = chars[l];
                    id++;
                } else {
                    List<Character> lst = numberToChar(r - l);
                    chars[id] = chars[l];
                    id++;
                    for (char c : lst) {
                        chars[id] = c;
                        id++;
                    }
                }
                l = r;
            }
        }
        if (r == l + 1) {
            chars[id] = chars[l];
            id++;
        } else {
            List<Character> lst = numberToChar(r - l);
            chars[id] = chars[l];
            id++;
            for (char c : lst) {
                chars[id] = c;
                id++;
            }
        }
        return id;
    }
}
