package src.Arrays;

/*
https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1
 */
public class LargestNumberKSwaps {
    public void solution(String number, int k) {
        char[] array = number.toCharArray();
        Result result = new Result();
        solution(array, k, result);
    }

    private void solution(char[] array, int k, Result result) {

        if (k == 0)
            return;
        // compare the two numbers
        for (var i = 0; i < array.length - 1; i++) {
            for (var j = i + 1; j < array.length; j++) {
                if (array[j] > array[i]) {
                    char temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;

                    String res = String.valueOf(array);
                    if (res.compareTo(result.max) > 0) {
                        result.max = res;
                    }

                    solution(array, k -1, result);

                    // backtrack
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}

class Result {
    public String max = "";
}
