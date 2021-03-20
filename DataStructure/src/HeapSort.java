public class HeapSort {
    public static void heapSort(int arr[]) {
        // method1:
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i , arr.length);
        }

        // method2:
        int temp = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // select the bigger
            if (k + 1 < length && arr[k] < arr[k+1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break; // wrong
            }
        }
    }
}
