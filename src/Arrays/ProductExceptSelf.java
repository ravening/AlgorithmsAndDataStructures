package Arrays;

/*
https://leetcode.com/problems/product-of-array-except-self/discuss/1804636/Simple-Java-Solution-No-Branching-complex-logic-O(n)
 */
public class ProductExceptSelf {

    public int[] solution(int[] array) {
        int[] result = new int[array.length];

        result[array.length-1] = 1;

        for (var i = array.length -2; i >= 0; i--) {
            result[i] = result[i+1] * array[i+1];
        }

        int lp = 1;

        for (var i = 0; i < array.length; i++) {
            result[i] = result[i] * lp;
            lp = lp * array[i];
        }

        return result;
    }

}
