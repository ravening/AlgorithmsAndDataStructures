package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
    public String solution(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] indegree = new int[26];
        buildGraph(words, graph, indegree);

        String s = topologicalSort(graph, indegree);

        return s.length() == graph.size() ? s : "";
    }

    private void buildGraph(String[] words, Map<Character, Set<Character>> map, int[] indegree) {
        for (var i = 1; i < words.length; i++) {
            String first = words[i-1];
            String second = words[i];

            int length = Math.min(first.length(), second.length());

            for (var j = 0; j < length; j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    map.computeIfAbsent(first.charAt(j), k -> new HashSet<>()).add(second.charAt(j));
                    indegree[second.charAt(j) - 'a']++;
                    break;
                }
            }
        }
    }

    private String topologicalSort(Map<Character, Set<Character>> map, int[] indegree) {
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
       for (Character key : map.keySet()) {
           if (indegree[key - 'a'] == 0) {
               queue.add(key);
           }
       }

       while (!queue.isEmpty()) {
           Character ch = queue.poll();
           sb.append(ch);
           for (Character neighbour : map.get(ch)) {
               indegree[neighbour - 'a']--;
               if (indegree[neighbour - 'a'] == 0) {
                   queue.add(neighbour);
               }
           }
       }

       return sb.toString();
    }
}
