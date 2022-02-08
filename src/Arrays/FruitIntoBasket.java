package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/discuss/general-discussion/657507/sliding-window-for-beginners-problems-template-sample-solutions/
 */
public class FruitIntoBasket {
    public static int solution(int[] array) {
        int result = 0, j = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (var i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i],1);
            }

            while (j < array.length && map.size() > 2) {
                map.put(array[j], map.get(array[j]) - 1);
                if (map.get(array[j]) == 0) {
                    map.remove(array[j++]);
                }
            }

            result = Math.max(result, i - j + 1);
        }

        return result;
    }
}
