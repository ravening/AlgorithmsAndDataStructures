package Arrays;

/*
https://www.geeksforgeeks.org/sort-a-nearly-sorted-or-k-sorted-array-set-2-gap-method-shell-sort/?ref=rp
 */
public class KSortedArray {
    public static void main(String[] args) {
        int arr[] = { 10, 9, 8, 7, 4, 70, 60, 50 };
        int K = 4;

        solution(arr, K);

        for (var i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void solution(int[] array, int K) {
        for (var gap = K; gap > 0; gap = nextGap(gap)) {
            for (var i =0 ; i + gap < array.length; i++ ) {
                if (array[i] > array[i + gap]) {
                    swap(array, i, i + gap);
                }
            }
        }
    }

    public static int nextGap(int gap) {
        if (gap < 2)
            return 0;

        return (int) Math.ceil(gap / 2.0);
    }

    public static void swap(int[] array, int start, int end) {
        int tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;
    }
}
