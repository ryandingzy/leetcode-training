class Solution {
    public boolean isReflected(int[][] points) {
        Arrays.sort(points, (p1, p2) -> p1[0] - p2[0]);
        Arrays.sort(points, (p1, p2) -> p1[1] - p2[1]);
        int lastY = points[0][1];
        int firstIndex = 0;
        boolean found = false;
        double existingLineY = 0.0;
        for(int i = 0; i <= points.length; i ++) {
            if(i == points.length || points[i][1] != lastY) {
                int lastIndex = i - 1;
                while(firstIndex <= lastIndex) {
                    while(firstIndex + 1 < points.length && 
                          Arrays.equals(points[firstIndex],points[firstIndex + 1])) {
                        firstIndex ++;
                    }
                    while(lastIndex -1 >=0 &&
                          Arrays.equals(points[lastIndex], points[lastIndex -1])) {
                        lastIndex --;
                    }
                    double lineY = (points[firstIndex][0] + points[lastIndex][0]) / 2.0;
                    if(found && lineY != existingLineY) {
                        return false;
                    } else {
                        found = true;
                        existingLineY = lineY;
                    }
                    firstIndex ++;
                    lastIndex --;
                }
                if(i < points.length) {
                    firstIndex = i;
                    lastY = points[i][1];
                }
                
            }
        }
        return true;
    }
}


// 也可以通过hashmap找对应点的方法，判断中线的有效性。hashmap可以有助于去重复