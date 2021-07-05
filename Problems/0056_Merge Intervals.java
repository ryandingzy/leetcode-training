class Solution {
    public int[][] merge(int[][] intervals) {
        // sort
        quickSort(intervals, 0, intervals.length - 1);
        // merge
        List<int[]> lst = new ArrayList<>();
        lst.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (lst.get(lst.size() - 1)[1] < intervals[i][0]) {
                lst.add(intervals[i]);
            } else {
                lst.get(lst.size() - 1)[1] = Math.max(lst.get(lst.size() - 1)[1], intervals[i][1]);
            }
        }
        // return
        int[][] res = new int[lst.size()][2];
        for (int i = 0; i < lst.size(); i++) {
            res[i] = lst.get(i);
        }
        return res;
    }
    
    public void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public int partition(int[][] arr, int low, int high) {
        int[] pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j][0] < pivot[0]) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    public void quickSort(int[][] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }
}