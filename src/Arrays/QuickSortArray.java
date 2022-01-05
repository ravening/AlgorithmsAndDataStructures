package Arrays;

public class QuickSortArray {
    public static void solution(int[] array, int low, int high) {
        if (low < high) {
            int partition = partition(array, low, high);
            solution(array, low, partition - 1);
            solution(array, partition + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int x = array[high];
        int i = low - 1;

        for (var j = low; j < high; j++) {
            if (array[j] <= x) {
                i++;
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        int tmp = array[i+1];
        array[i+1] = x;
        array[high] = tmp;

        return i + 1;
    }
}
