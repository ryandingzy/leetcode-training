class Solution {
    private double getDistance(int[] p1, int[] p2) {
        return Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double d1 = getDistance(p1, p2);
        if (d1 != getDistance(p3, p4)) return false;
        double d2 = getDistance(p1, p3);
        if (d2 != getDistance(p2, p4)) return false;
        double d3 = getDistance(p1, p4);
        if (d3 != getDistance(p2, p3)) return false;
        if (d1 > d2) {
            return d2 == d3;
        } else if (d1 < d2) {
            return d1 == d3;
        } else {
            return d3 > d1;
        }
    }
}
