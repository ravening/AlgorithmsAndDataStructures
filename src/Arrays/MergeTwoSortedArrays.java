package Arrays;

/*
https://www.geeksforgeeks.org/efficiently-merging-two-sorted-arrays-with-o1-extra-space/
 */
public class MergeTwoSortedArrays {
    public void solution(int[] array1, int[] array2) {

        int m = array1.length;
        int n = array2.length;

        for (var i = 0; i < m; i++) {
            if (array1[i] > array2[0]) {
                int temp = array1[i];
                array1[i] = array2[0];
                array2[0] = temp;

                int firstElement = array2[0];

                int k;
                for (k = 1; k < n && array2[k] < array2[k-1]; k++) {
                    array2[k-1] = array2[k];
                }
                array2[k] = firstElement;
            }
        }
    }
}
