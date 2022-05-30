package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://dev.to/clarkngo/logic-explained-meeting-scheduler-leetcode-java-using-two-pointers-4881
 */

/*
https://leetcode.com/problems/meeting-scheduler/
 */
public class MeetingScheduler {
    public List<Integer> meetingScheduler(int[][] personA, int[][] personB, int duration) {
        Arrays.sort(personA, (a, b) -> a[0] - b[0]);
        Arrays.sort(personB, (a, b) -> a[0] - b[0]);

        int i = 0, j = 0;

        while (i < personA.length && j < personB.length) {
            int[] slotA = personA[i];
            int[] slotB = personB[j];

            int start = Math.max(slotA[0], slotB[0]);
            int end = Math.min(slotA[1], slotB[1]);

            if (start + end >= duration) {
                return Arrays.asList(start, start + duration);
            } else if (slotA[1] < slotB[1]) {
                i++;
            } else if (slotA[1] > slotB[1]) {
                j++;
            } else {
                i++;
                j++;
            }
        }

        return new ArrayList<>();
    }
}
