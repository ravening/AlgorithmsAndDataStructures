package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[nums.length - k +1];
        int index = 0;

        for (var i = 0; i < nums.length; i++) {
            // remove elements outside of window
            while (!queue.isEmpty() && queue.peek() < (i - k + 1)) {
                queue.poll();
            }

            // remove smaller elements from queue
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            queue.offer(i);

            if (i >= k - 1) {
                result[index++] = nums[queue.peek()];
            }
        }

        return result;

    }
}
