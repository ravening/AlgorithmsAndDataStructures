package Arrays;

/*
https://www.geeksforgeeks.org/find-duplicates-constant-array-elements-0-n-1-o1-space/?ref=rp
 */
public class DuplicateElement {
    public int duplicate(int[] array) {
        if (array.length == 1) {
            return -1;
        }

        if (array.length == 2 && (array[0] != array[1])) {
            return -1;
        }

        int slow = array[0];
        int fast = array[array[0]];

        while (slow != fast) {
            slow = array[slow];
            fast = array[array[fast]];
        }

        fast = 0;

        while (slow != fast) {
            slow = array[slow];
            fast = array[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        DuplicateElement duplicateElement = new DuplicateElement();
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 3};
        System.out.println(duplicateElement.duplicate(array));
    }
}
