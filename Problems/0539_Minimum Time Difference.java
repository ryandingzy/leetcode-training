class Solution {
    final int MID = 12 * 60;
    final int TOTAL = 24 * 60;

    private int getDiff(String t1, String t2) {
        String[] arr1 = t1.split("\\:");
        String[] arr2 = t2.split("\\:");
        int h1 = Integer.valueOf(arr1[0]);
        int h2 = Integer.valueOf(arr2[0]);
        int m1 = Integer.valueOf(arr1[1]);
        int m2 = Integer.valueOf(arr2[1]);
        int diff = (h2 - h1) * 60 + (m2 - m1);
        if (diff > MID) {
            return TOTAL - diff;
        } else {
            return diff;
        }
    }
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int n = timePoints.size();
        int min = getDiff(timePoints.get(0), timePoints.get(n - 1));
        for (int i = 1; i < n; i++) {
            min = Math.min(min, getDiff(timePoints.get(i - 1), timePoints.get(i)));
        }
        return min;
    }
}
