package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC904 {
    public static void main(String[] args) {
        LC904 lc904 = new LC904();
        int[] nums = new int[]{1,2,1};

        Result result = lc904.solution(nums, 2);

        System.out.println(result.endIndex);
    }

    public Result solution(int[] word, int k) {
        Result result = new Result();

        if (word == null || word.length == 0 || k == 0) {
            return result;
        }

        int i = 0, j, max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (j = 0; j < word.length; j++) {
            map.put(word[j], map.getOrDefault(word[j], 0) + 1);

            while (map.size() > k) {
                map.put(word[i], map.get(word[i]) - 1);
                map.remove(word[i++], 0);
            }

            if ((j - i + 1) > max) {
                max = j - i + 1;
                result.endIndex = j;
                result.startIndex = i;
            }
        }

        return result;
    }
}
