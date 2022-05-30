package Arrays;

import java.util.*;

/*
https://www.careercup.com/question?id=5106869203369984
 */
public class CommonArrayElements {
    public List<Integer> getCommonElements(List<List<Integer>> lists) {
        Set<Integer> answer = new HashSet<>();
        Set<Integer> uniqueNumbers = new HashSet<>();

        lists.forEach(list -> {
            new HashSet<>(list).forEach(value -> {
                if (uniqueNumbers.contains(value)) {
                    answer.add(value);
                } else {
                    uniqueNumbers.add(value);
                }
            });
        });

        return new ArrayList<>(answer);
    }

    public static void main(String[] args) {
        CommonArrayElements commonArrayElements = new CommonArrayElements();

        List<List<Integer>> input = new ArrayList<List<Integer>>();
        for (var i = 0; i < 3; i++) {
            input.add(0, new ArrayList<>());
        }

        input.get(0).addAll(List.of(2, 5, 3, 2, 8, 1));
        input.get(1).addAll(List.of(7, 9, 5, 2, 4, 10, 10));
        input.get(2).addAll(List.of(6, 7, 5, 5, 3, 7));

        List<Integer> result = commonArrayElements.getCommonElements(input);
        System.out.println(result);
    }
}
