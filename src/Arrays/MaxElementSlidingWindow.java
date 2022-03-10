package Arrays;

import java.util.*;

/*
https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k-using-stack-in-on-time/?ref=lbp
 */
public class MaxElementSlidingWindow {
    int[] array;
    int[] maxUpto;
    Stack<Integer> stack;
    int length;
    Deque<Integer> deque;

    MaxElementSlidingWindow(int[] a, int k) {
        this.array = new int[a.length];
        this.array = a;
        this.maxUpto = new int[a.length];
        this.stack = new Stack<>();
        this.length = k;
        this.deque = new ArrayDeque<>();
    }

    /*
    https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
     */
    private void betterSolution() {
        List<Integer> result = new ArrayList<>();

        for (var i = 0; i < array.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - this.length + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && array[deque.peekLast()] < array[i]) {
                deque.poll();
            }

            deque.offer(i);

            if (i >= this.length - 1) {
                result.add(array[deque.peek()]);
            }
        }

        for (var i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    private void solution() {
        Arrays.fill(maxUpto, 0);
        stack.push(0);

        for (var i =1; i < array.length; i++) {
            while (!stack.isEmpty() && array[i] > array[stack.peek()]) {
                maxUpto[stack.peek()] = i - 1;
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            maxUpto[stack.peek()] = array.length - 1;
            stack.pop();
        }
        int j = 0;
        for (var i = 0; (i < array.length - length + 1); i++) {
            while (j < i || maxUpto[j] < (i + length - 1)) {
                j++;
            }
            System.out.print(array[j] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {9,7,2,4,6,8,2,1,5};
        MaxElementSlidingWindow slidingWindow =
                new MaxElementSlidingWindow(array, 3);

        slidingWindow.solution();
        slidingWindow.betterSolution();

        int[] arr = {6, 7, 5, 2, 1, 7, 2, 1, 10};
        slidingWindow = new MaxElementSlidingWindow(arr, 2);
        slidingWindow.solution();
    }
}
