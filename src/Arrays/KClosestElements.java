package Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
https://www.techiedelight.com/find-k-closest-elements-to-given-value-array/
 */
public class KClosestElements {
    public static List<Integer> solution(int[] array, int k, int key) {
        int low = 0, high = array.length - 1;

        while (high - low >= k) {
            if (Math.abs(array[low] - key) > Math.abs(array[high] - key)) {
                low++;
            } else {
                high--;
            }
        }

        return Arrays.stream(array, low, high + 1).boxed().collect(Collectors.toList());
    }
}
