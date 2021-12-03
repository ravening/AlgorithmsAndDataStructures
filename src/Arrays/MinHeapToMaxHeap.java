package Arrays;

/*
https://www.geeksforgeeks.org/convert-min-heap-to-max-heap/?ref=rp
 */
public class MinHeapToMaxHeap {
    public static void main(String[] args) {
        int arr[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        printArray(arr);

        convertToMaxHeap(arr);
        printArray(arr);
    }

    public static void printArray(int[] array) {
        for (var i : array)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void convertToMaxHeap(int[] array) {
        int n = array.length;

        for (var i = (n-2)/2; i >=0; i--) {
            maxHeapify(array, i, n);
        }
    }

    public static void maxHeapify(int[] array, int i, int n) {
        int left = 2* i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < n && (array[left] > array[i]))
            largest = left;

        if (right < n && (array[right] > array[largest]))
            largest = right;

        if (largest != i) {
            int tmp = array[i];
            array[i] = array[largest];
            array[largest] = tmp;
            maxHeapify(array, largest, n);
        }

    }
}
