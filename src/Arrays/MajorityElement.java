package Arrays;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/majority-element/?ref=lbp
 */
public class MajorityElement {

    public void findMajorityElement(int[] array) {
        int candidate = findCandidate(array);
        if (isMajority(candidate, array)) {
            System.out.println(candidate);
        } else {
            System.out.println("Not found");
        }
    }

    private int findCandidate(int[] array) {
        int majorityIndex = 0;
        int count = 1;

        for (var i = 1; i < array.length; i++) {
            if (array[majorityIndex] == array[i]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
            System.out.println("count is " + count + " and index is " + majorityIndex);
        }

        return array[majorityIndex];
    }

    private boolean isMajority(int candidate, int[] array) {
        long count = 0;

        count = Arrays.stream(array)
                .filter(value -> value == candidate)
                .count();

        return count >= (array.length / 2);
    }

    public static void main(String[] args) {
        int a[] = new int[] { 1, 3, 3, 1, 2 , 3};
        MajorityElement majorityElement = new MajorityElement();
        majorityElement.findMajorityElement(a);
    }
}
