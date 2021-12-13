class Solution {
    public int peakIndexInMountainArray(int[] arr) { // [0, 3, 5, 3]
        return binarySearch(arr, 0, arr.length - 1);
    }
    
    private int binarySearch(int[] arr, int left, int right) { // [0, 3, 5, 3], 2, 3
        if (left == right - 1) return arr[left] > arr[right] ? left : right; // 2
        
        int mid = left + (right - left) / 2; // 2
        
        if (arr[mid] > arr[mid - 1]) { // true
            return binarySearch(arr, mid, right); // 2, 3
        } else {
            return binarySearch(arr, left, mid);
        }
    }
}


// int binarySearch(arr, left, right)
// mid , mid - 1


// 1 [0, 1, 0] == 1
// 2 [0, 3, 5, 3]
