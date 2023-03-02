class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        double count = Math.log(buckets) / Math.log(minutesToTest / minutesToDie + 1);
        return Math.abs(count - Math.round(count)) < 1e-10 ? (int)count : (int)(count + 1);
    }
}
