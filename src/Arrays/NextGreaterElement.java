// given an array of elements, print the next greater element to the right of it
package Arrays;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    /*
    https://www.techiedelight.com/next-greater-element/
     */
    public int[] nextGreaterElement(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[array.length];
        Arrays.fill(output, -1);

        for (var i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[i] > array[stack.peek()]) {
                output[stack.pop()] = array[i];
            }

            stack.push(i);
        }

        return output;
    }

    /*
    https://www.geeksforgeeks.org/next-greater-element/
    without extra array
     */

    public int[] solutionWithoutExtraArray(int[] array) {
        Stack<Integer> stack = new Stack<>();

        for (var i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
                array[stack.peek()] = array[i];
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            array[stack.peek()] = -1;
        }
        return array;
    }

    public void solution(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[array.length];

        for (int i = array.length -1; i>= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() < array[i])
                    stack.pop();
            }

            output[i] = stack.empty() ? -1 : stack.peek();
            stack.push(array[i]);
        }
    }

    /*
    https://www.techiedelight.com/find-maximum-value-index-array/
     */

    public int maxDiff(int[] array) {
        int diff = Integer.MIN_VALUE;
        int[] aux = new int[array.length];

        aux[array.length-1] = array[array.length-1];

        for (var j = array.length - 2; j >= 0; j--) {
            aux[j] = Math.max(array[j], aux[j+1]);
        }

        for (int i=0, j = 0; i < array.length && j < array.length;) {
            if (array[i] < aux[j]) {
                diff = Math.max(diff, j - i);
                j++;
            } else {
                i++;
            }
        }

        return diff;
    }
}
