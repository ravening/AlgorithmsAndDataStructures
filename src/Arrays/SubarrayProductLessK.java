package Arrays;

/*
https://www.geeksforgeeks.org/number-subarrays-product-less-k/
 */
public class SubarrayProductLessK {

    public int solution(int[] array, int k) {
        if (array == null || array.length == 0) {
            return  0;
        }

        int start = 0, end = 0;
        int p = 0, result = 0;
        while (end < array.length) {
            p = p * array[end++];

            while (start < end && p >= k) {
                p = p / array[start++];
            }

            if (p < k) {
                int len = end - start + 1;
                result += len;
            }
        }

        return result;
    }
}
