class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append((char)('A' + (columnNumber - 1) % 26));
        while (columnNumber > 26) {
            columnNumber = (columnNumber - 1) / 26;
            sb.append((char)('A' + (columnNumber - 1) % 26));
        }
        return sb.reverse().toString();
    }
}
