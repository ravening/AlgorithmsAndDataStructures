package leetcode;


import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-number-of-refueling-stops/description/
 *
 *To solve this problem efficiently, we can use a max-heap (priority queue) to always refuel with the gas from the
 * station that provides the maximum fuel among all reachable stations at each step. This greedy approach ensures we
 * are always making the best decision to extend our range.
 */
public class LC871 {

    public static void main(String[] args) {
        LC871 lc871 = new LC871();
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        int target = 100;
        int startFuel = 10;

        System.out.println(lc871.solution(stations, startFuel, target));
    }
    public int solution(int[][] stations, int startFuel, int target) {
        if (startFuel > target) {
            return 0;
        }

        int fuel = startFuel;
        int index = 0;
        int stops = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        while (fuel < target) {
            while (index < stations.length && stations[index][0] <= fuel) {
                queue.add(stations[index++][1]);
            }

            // if queue is empty, we cant reach target
            if (queue.isEmpty()) {
                return -1;
            }

            fuel += queue.poll();
            stops++;
        }

        return stops;
    }
}
