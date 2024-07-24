import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Parser
 */
public class Parser {

    public static void main(String[] args) throws IOException {
//        String fileName = "/Users/r.venkatesh/apilog.log";
//
//        Stream<String> stream = Files.lines(Paths.get(fileName));
//        stream.forEach(line -> {
//            String[] words = line.split(" ");
//            System.out.println(words[12]);
//        });
//        stream.close();

        Map<String, Integer> map = new HashMap<>();
        map.put("john", 1);
        map.put("jane", 2);
        map.put("doe", 3);

        System.out.println(Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey());

        List<List<Integer>> lists = new ArrayList<>();

        lists.add(new ArrayList<>(map.values()));
        lists.add(new ArrayList<>(map.values()));
        lists.add(new ArrayList<>(map.values()));
        lists.add(new ArrayList<>(map.values()));
        lists.get(0).add(1);
        lists.get(0).add(2);
        lists.get(1).add(3);

        System.out.println(lists.size());
    }
}
