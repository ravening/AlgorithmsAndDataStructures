package Arrays;

import java.util.*;

/*
https://leetcode.com/discuss/interview-question/397524/
 */
public class DelayedProjects {
    public List<String> getDelayedProjects(List<String[]> dependencies, List<String> delayed) {
        Map<String, Set<String>> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        for (String[] entry : dependencies) {
            map.computeIfAbsent(entry[0], k -> new HashSet());
            map.get(entry[0]).add(entry[1]);
        }

        for (String delay : delayed) {
            queue.add(delay);
        }
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String tmp = queue.poll();
            queue.addAll(map.get(tmp));
            result.add(tmp);
        }

        Collections.sort(result);

        return result;
    }
}
