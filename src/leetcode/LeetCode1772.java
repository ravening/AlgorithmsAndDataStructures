package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Sort Features by Popularity,” requires sorting features based on their popularity in a given list of responses
 */
public class LeetCode1772 {

    public List<String> sortFeatures(String[] features, String[] queries) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : features) {
            map.put(word, 0);
        }

        for (String response : queries) {
            Set<String> set = new HashSet<>();
            for (String word : response.split(" ")) {
                if (map.containsKey(word) && !set.contains(word)) {
                    map.put(word, map.get(word) + 1);
                    set.add(word);
                }
            }
        }

        List<String> res = Arrays.asList(features);

        res.sort((a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);

            if (freqA == freqB) {
                return 0;
            }
            return freqB - freqA;
        });

        return res;
    }

    public static void main(String[] args) {
        String[] features = {"cooler", "lock", "touch"};
        String[] queries = {"i like cooler cooler", "lock touch cool", "locker cooler touch"};

        LeetCode1772 solution = new LeetCode1772();
        System.out.println(solution.sortFeatures(features, queries));
    }
}
