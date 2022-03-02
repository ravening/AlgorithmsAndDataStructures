package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int solution(int[] array) {
        Set<Integer> set = new HashSet<>();

        for (var i : array) {
            set.add(i);
        }

        int max = 0;
        for (var key : set) {
            if (!set.contains(key - 1)) {
                int length = 0;
                int current = key;
                while (set.contains(current++)) {
                    length++;
                }
                max = Math.max(max, length);
            }
        }

        return max;
    }
}
