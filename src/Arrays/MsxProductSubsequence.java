package Arrays;

/*
https://www.careercup.com/question?id=16813665
 */
public class MsxProductSubsequence {
    public int solution(int[] array) {
        int left = 0, right = 0;
        int maxProduct = 0;
        for (var i = 1; i < array.length - 1; i++) {
            for (var j = 0; j < i; j++) {
                if (array[j] < array[i] && array[j] > left) {
                    left = array[j];
                }
            }

            for (var j = i + 1; j < array.length; j++) {
                if (array[j] > array[i] && array[j] > right) {
                    right = array[j];
                }
            }

            int tmpProduct = array[i] * left * right;
            maxProduct = Math.max(maxProduct, tmpProduct);
        }

        return maxProduct;
    }
}
