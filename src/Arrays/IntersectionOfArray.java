package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://www.careercup.com/question?id=5158359730749440
 */
public class IntersectionOfArray {

    public int[] solution(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int x : b) {
            if (map.containsKey(x) && map.get(x) > 0) {
                result.add(x);
                map.put(x, map.get(x) - 1);
            }
        }

        int[] array = new int[result.size()];

        for (var i = 0; i < array.length; i++) {
            array[i] = result.get(i);
        }

        return array;
    }
}
