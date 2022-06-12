package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
https://www.techiedelight.com/find-itinerary-from-given-list-tickets/
 */
public class MakeItinerary {

    public static void main(String[] args) {
        // input: list of tickets
        String[][] input = new String[][]{
                {"LAX", "DXB"},
                {"DFW", "JFK"},
                {"LHR", "DFW"},
                {"JFK", "LAX"}
        };

        solution(input);

    }
        public static void solution(String[][] itinerary) {
        Map<String, String> map = Arrays.stream(itinerary)
                .collect(Collectors.toMap(p -> p[0], p -> p[1]));

        Set<String> airportsSet = new HashSet<>(map.values());

        for (var array : itinerary) {
            if (!airportsSet.contains(array[0])) {
                display(map, array[0]);
                break;
            }
        }
    }

    public static void display(Map<String, String> map, String source) {
        while (map.containsKey(source)) {
            System.out.println(source + " -> " + map.get(source));
            source = map.get(source);
        }
    }
}
