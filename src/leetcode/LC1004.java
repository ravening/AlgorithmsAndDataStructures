package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 */
public class LC1004 {

    public int longestOnes(int[] A, int k) {
        int left = 0, count = 0, max = 0;

        for (int right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                count++;
            }

            while (count > k) {
                if (A[left++] == 0) {
                    count--;
                }
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public List<Integer> longestOnesWithFlipped0Index(int[]A, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int left = 0, max = 0;

        for (int right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                deque.addLast(right);
            }

            if (deque.size() > k) {
                left = deque.removeFirst();
            }

            max = Math.max(max, right - left + 1);
        }

        return new ArrayList<>(deque);
    }
}
