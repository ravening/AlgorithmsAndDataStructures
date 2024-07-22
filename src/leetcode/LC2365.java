package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/task-scheduler-ii/solutions/2388105/c-python3-hashmap-to-store-previous-occurence-o-n/
 */
public class LC2365 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,2,3,1};
        int space = 3;

        LC2365 lc2365 = new LC2365();
        System.out.println(lc2365.taskSchedulerII(nums, space));
    }

    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        long currentDay = 0;

        for (int task : tasks) {
            currentDay++;

            if (map.containsKey(task) && (currentDay - map.get(task)) <= space) {
                currentDay += space - (currentDay - map.get(task)) + 1;
            }

            map.put(task, currentDay);
        }

        return currentDay;
    }
}
