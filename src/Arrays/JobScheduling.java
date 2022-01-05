package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://www.geeksforgeeks.org/job-sequencing-using-disjoint-set-union/?ref=lbp
 */
public class JobScheduling {
    static class Job {
        char id;
        int profit;
        int deadline;

        Job(char a, int d, int p) {
            this.id = a;
            this.profit = p;
            this.deadline = d;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "id=" + id +
                    ", profit=" + profit +
                    ", deadline=" + deadline +
                    '}';
        }
    }

    static class DisjointSet {
        int[] parent;
        DisjointSet(int length) {
            this.parent = new int[length + 1];

            for (var i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        int find(int slot) {
            if (slot == parent[slot])
                return slot;

            return parent[slot] = find(parent[slot]);
        }

        void merge(int par, int child) {
            this.parent[child] = par;
        }
    }

    int maxTimeSlot(List<Job> jobs) {
        int ans = Integer.MIN_VALUE;
        for (var job : jobs) {
            ans = Math.max(ans, job.deadline);
        }

        return ans;
    }

    void scheduleJobs(List<Job> jobs) {
        Collections.sort(jobs, (j1, j2) -> {return (j1.profit > j2.profit) ? -1 : 1;});
        int maxSlot = maxTimeSlot(jobs);
        DisjointSet disjointSet = new DisjointSet(maxSlot);

        for (var job : jobs) {
            int availableSlot = disjointSet.find(job.deadline);
            if (availableSlot > 0) {
                disjointSet.merge(disjointSet.find(availableSlot - 1), availableSlot);
                System.out.print(job + " ");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Job> arr =new ArrayList<Job>();
        arr.add(new Job('a',2,100));
        arr.add(new Job('b',1,19));
        arr.add(new Job('c',2,27));
        arr.add(new Job('d',1,25));
        arr.add(new Job('e',3,15));

        JobScheduling jobScheduling =
                new JobScheduling();
        jobScheduling.scheduleJobs(arr);
    }
}
