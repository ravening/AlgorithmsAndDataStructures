package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/process-tasks-using-servers/
 */
public class LeetCode1882 {
    static class Pair {
        int weight;
        int id;
        int time;

        Pair(int w, int i, int t) {
            this.weight = w;
            this.id = i;
            this.time = t;
        }

        public int getWeight() {
            return weight;
        }

        public int getId() {
            return id;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }

    Comparator<Pair> freeServer = Comparator.comparing(Pair::getWeight).thenComparing(Pair::getId);
    Comparator<Pair> usedServer = Comparator
            .comparing(Pair::getTime).thenComparing(freeServer);

    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Pair> freeServers = new PriorityQueue<>(freeServer);
        PriorityQueue<Pair> usedServers = new PriorityQueue<>(usedServer);

        for (var i = 0; i < servers.length; i++) {
            freeServers.add(new Pair(servers[i], i, 0));
        }

        int[] result = new int[tasks.length];

        for (var i = 0; i < tasks.length; i++) {
            int taskDuration = tasks[i];

            // if any server has finished processing, add back to free queue
            while (!usedServers.isEmpty() && usedServers.peek().time <= i) {
                freeServers.add(usedServers.remove());
            }

            // check if any server is free
            if (!freeServers.isEmpty()) {
                Pair pair = freeServers.poll();
                result[i] = pair.getId();
                pair.setTime(i + taskDuration);
                usedServers.add(pair);
            } else {
                // if there are no free servers, assign the current task to the latest available server
                Pair pair = usedServers.poll();
                result[i] = pair.getId();
                pair.setTime(pair.getTime() + taskDuration);
                usedServers.add(pair);
            }
        }

        return result;
    }
}
