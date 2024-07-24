package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/discuss/interview-question/5527127/Google-coding-round-3-question
 */
public class LongestIncrementalSubsequence {

    public static void main(String[] args) {
        LongestIncrementalSubsequence lis = new LongestIncrementalSubsequence();
        int[] arr = {2,3,1,4,5,6};
        System.out.println(lis.solution(arr));
    }
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreqeuncy = 0;
        int maxElement = 0;

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i] - 1)) {
                int count = map.get(array[i] - 1);
                map.put(array[i], ++count);

                if (maxFreqeuncy < count) {
                    maxFreqeuncy = count;
                    maxElement = array[i];
                }
            } else {
                map.put(array[i], 1);
            }
        }

        int[] result = new int[maxFreqeuncy];
        for (int i = maxFreqeuncy - 1; i >= 0; i--) {
            result[i] = maxElement--;
        }

        IntStream.of(result).forEach(System.out::println);

        return maxFreqeuncy;
    }
}
