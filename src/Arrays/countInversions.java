package src.Arrays;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/counting-inversions/
 */
public class countInversions {
    public int solution(int[] array, int left , int right) {
        int l = 0;
        int r = array.length;
        int count = 0;
        if (l < r) {
            int mid = (l + r) / 2;

            count += solution(array, l, mid);

            count += solution(array, mid + 1, r);

            count += merge(array, l, mid, r);
        }

        return count;
    }

    private int merge(int[] array, int l, int mid, int r) {
        int[] left = Arrays.copyOfRange(array, l, mid + 1);
        int[] right = Arrays.copyOfRange(array,mid + 1,r+1);
        int i =0, k=0, j =0;
        int swaps = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
                swaps += mid + 1 - (i + l);
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = left[j++];
        }

        return swaps;
    }
}
