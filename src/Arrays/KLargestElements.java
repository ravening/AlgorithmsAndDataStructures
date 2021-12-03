package Arrays;


import java.util.PriorityQueue;

/*
https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/?ref=lbp
 */
public class KLargestElements {
    PriorityQueue<Integer> priorityQueue;
    int[] array;

    KLargestElements(int[] a) {
        this.array = a;
        this.priorityQueue = new PriorityQueue();
    }

    public void solution(int k) {
        for (var i = 0; i < k; i++) {
            priorityQueue.add(array[i]);
        }

        for (var i = k ; i < array.length; i++) {
            if (array[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(array[i]);
            }
        }

        for (Integer integer : priorityQueue) {
            System.out.print(integer + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 11, 3, 2, 1, 15, 5, 4,
                45, 88, 96, 50, 45 };
        KLargestElements kLargestElements =
                new KLargestElements(arr);
        kLargestElements.solution(3);
    }
}
