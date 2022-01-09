class Solution {
    private char getChar(int num) {
        if (num < 10) {
            return (char)('0' + num);
        } else if (num == 10) return 'a';
        else if (num == 11) return 'b';
        else if (num == 12) return 'c';
        else if (num == 13) return 'd';
        else if (num == 14) return 'e';
        else return 'f';
    }
    
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) return "0";
        
        while (num != 0) {
            sb.append(getChar(num & 0xf));
            num >>>= 4;
        }
        sb.reverse();
        return sb.toString();
    }
}
