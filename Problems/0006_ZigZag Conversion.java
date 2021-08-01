class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows)
            return s;
        if (numRows == 1)
            return s;
        StringBuffer sb = new StringBuffer("");
        int interval = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; ; j++) {
                if (i != 0 && i != numRows - 1 && j > 0) {
                    if (j * interval - i < s.length()) {
                        sb.append(s.charAt(j * interval - i));
                    } else {
                        break;
                    }
                }
                if (i + j * interval < s.length()) {
                    sb.append(s.charAt(i + j * interval));
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }
}
