class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                if (a1[0] == a2[0]) {
                    if (a1[1] > a2[1]) return 1;
                    else if (a1[1] == a2[1]) return 0;
                    else return -1;
                } else if (a1[0] > a2[0]) return 1;
                else return -1;
            }
        });
        int left = points[0][0];
        int right = points[0][1];
        int res = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > right) {
                res++;
                left = points[i][0];
                right = points[i][1];
            } else {
                left = points[i][0];
                right = Math.min(right, points[i][1]);
            }
        }
        return res + 1;
    }
}
