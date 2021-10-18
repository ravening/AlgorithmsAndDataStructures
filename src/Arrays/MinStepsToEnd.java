/*
https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/
 */
package Arrays;

public class MinStepsToEnd {
    int[] array;

    public MinStepsToEnd(int[] array) {
        this.array = array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int solution() {
        // if array contains just one element then no jump needed
        if (array.length <= 1)
            return 0;

        // if we cant jump then no solution
        if (array[0] == 0)
            return -1;

        int maxReach = array[0];
        int steps = array[0];
        int jump = 1;

        for (var i = 1; i < array.length; i++) {
            if (i == array.length - 1)
                return jump;

            // update the maxreach for every step
            maxReach = Math.max(maxReach, i + array[i]);

            // reduce the number of steps
            steps--;

            // check if we run out of steps
            if (steps == 0) {
                jump++;

                // if we are in index which is greater than maxreach then we cant reach end
                if (i >= maxReach)
                    return -1;

                // update the remaining number of steps we can take
                steps = maxReach - i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        MinStepsToEnd minStepsToEnd = new MinStepsToEnd(arr);
        System.out.println(minStepsToEnd.solution());

        int arr1[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        minStepsToEnd.setArray(arr1);
        System.out.println(minStepsToEnd.solution());

    }
}
