class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean negative = (numerator > 0 && denominator < 0);
        
        List<Long> lst = new ArrayList<>();
        Map<Long, Integer> map = new HashMap<>();
        long num = numerator, den = denominator;
        long quotient = num / den;
        long remainder = num - den * quotient;
        lst.add(quotient);
        
        num = remainder * 10;
        int idx = 1;
        int repeatStart = 0;
        while (num != 0) {
            if (map.containsKey(num)) {
                repeatStart = map.get(num);
                break;
            }
            quotient = num / den;
            remainder = num - den * quotient;
            lst.add(quotient);
            map.put(num, idx++);
            num = remainder * 10;
        }
        
        // Convert to String
        StringBuilder sb = new StringBuilder(negative ? "-" : "");
        sb.append(String.valueOf(lst.get(0)));
        if (lst.size() == 1) return sb.toString();
        sb.append('.');
        for (int i = 1; i < lst.size(); i++) {
            if (repeatStart == i) sb.append('(');
            sb.append(String.valueOf(Math.abs(lst.get(i))));
            if (i == lst.size() - 1 && repeatStart != 0) sb.append(')');
        }
        return sb.toString();
    }
}
