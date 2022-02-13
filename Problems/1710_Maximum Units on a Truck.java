class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2) {
                return arr2[1] - arr1[1];
            }
        });
        int res = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize <= boxTypes[i][0]) {
                res += boxTypes[i][1] * truckSize;
                break;
            } else {
                res += boxTypes[i][1] * boxTypes[i][0];
                truckSize -= boxTypes[i][0];
            }
        }
        return res;
    }
}
