package Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
https://www.geeksforgeeks.org/merge-k-sorted-arrays-set-2-different-sized-arrays/
 */
public class MergeKSortedArrays {
    public List<Integer> solution(int[][] array) {
        List<Integer> output = new ArrayList<>();

        PriorityQueue<ArrayPair> pq = new PriorityQueue<>(array.length, Comparator.comparingInt(a -> a.value));

        // for sorting in reverse order
        PriorityQueue<ArrayPair> pqReverse = new PriorityQueue<>(array.length, Comparator.comparingInt(a -> a.value));

        for (var i = 0; i < array.length; i++) {
            pq.add(new ArrayPair(array[i][0], i, 0));
        }

        while (!pq.isEmpty()) {
            ArrayPair pair = pq.poll();

            output.add(pair.value);

            if (pair.indexInArray < array[pair.arrayIndex].length) {
                pq.add(new ArrayPair(array[pair.arrayIndex][pair.indexInArray + 1], pair.arrayIndex, pair.indexInArray + 1));
            }
        }

        return output;
    }
}

class ArrayPair {
    int value;
    int arrayIndex;
    int indexInArray;

    public ArrayPair(int value, int arrayIndex, int indexInArray) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.indexInArray = indexInArray;
    }
}
