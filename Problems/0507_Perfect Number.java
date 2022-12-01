class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 2) return false;
        Set<Integer> divisors = new HashSet<>();
        divisors.add(1);
        for (int i = 2; i < num; i++) {
            if (divisors.contains(i)) {
                break;
            }
            if (i > Math.sqrt(num)) {
                break;
            }
            if (num % i == 0) {
                divisors.add(i);
                divisors.add(num / i);
            }
        }
        int sum = 0;
        for (int d : divisors) {
            sum += d;
        }
        return num == sum;
    }
}
