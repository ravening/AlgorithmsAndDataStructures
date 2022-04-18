package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode1834 {
    static class Pair {
        int enqueTime;
        int processingTime;
        int id;

        
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public int getEnqueTime() {
            return enqueTime;
        }
        public void setEnqueTime(int enqueTime) {
            this.enqueTime = enqueTime;
        }
        public int getProcessingTime() {
            return processingTime;
        }
        public void setProcessingTime(int processingTime) {
            this.processingTime = processingTime;
        }
        public Pair(int enqueTime, int processingTime, int id) {
            this.enqueTime = enqueTime;
            this.processingTime = processingTime;
            this.id = id;
        }
    }

    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Pair> priorityQueue = 
            new PriorityQueue<>(Comparator.comparing(Pair::getEnqueTime).thenComparing(Pair::getProcessingTime).thenComparing(Pair::getId));

        for (var i = 0; i < tasks.length; i++) {
            priorityQueue.add(new Pair(tasks[i][0], tasks[i][1], i));
        }

        int[] result = new int[tasks.length];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            result[index++] = priorityQueue.poll().getId();
        }

        return result;
    }
}
