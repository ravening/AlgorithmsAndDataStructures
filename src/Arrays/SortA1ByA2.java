package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortA1ByA2 {
    public static void solution(int[] array1, int[] array2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[array1.length];

        for (var i : array1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        Arrays.sort(array1);

        int j = 0;

        for (var i : array2) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                while (count > 0) {
                    result[j++] = i;
                    count--;
                }
                map.remove(i);
            }
        }

        for (var i : array1) {
            if (map.containsKey(i)) {
                result[j++] = i;
            }
        }

        for (var i : result)
            System.out.print(i + " ");
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] array2 = new int[]{2,1,8,3};
        solution(array1, array2);
    }
}
