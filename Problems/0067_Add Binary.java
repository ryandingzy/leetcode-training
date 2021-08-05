class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int ia = a.length() - 1;
        int ib = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (ia >= 0 && ib >= 0) {
            int sum = a.charAt(ia) - '0' + b.charAt(ib) - '0' + carry;
            carry = sum / 2;
            sb.append((char)(sum % 2 + '0'));
            ia--;
            ib--;
        }
        while (ia >= 0) {
            int sum = a.charAt(ia) - '0' + carry;
            carry = sum / 2;
            sb.append((char)(sum % 2 + '0'));
            ia--;
        }
        while (ib >= 0) {
            int sum = b.charAt(ib) - '0' + carry;
            carry = sum / 2;
            sb.append((char)(sum % 2 + '0'));
            ib--;
        }
        if (carry == 1) {
            sb.append((char)(carry + '0'));
        }
        return sb.reverse().toString();
    }
}
