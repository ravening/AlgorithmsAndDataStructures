package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterFrequency {
    int[] array;
    Stack<Pair> stack;
    Map<Integer, Integer> map;

    static class Pair {
        int data;
        int freq;

        Pair(int d, int f) {
            this.data = d;
            this.freq = f;
        }
    }

    NextGreaterFrequency(int[] a) {
        this.array = a;
        this.stack = new Stack<>();
        this.map = new HashMap<>();
    }

    public void solution() {
        int[] res = new int[array.length];

        for (int j : array) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }

        res[array.length - 1] = -1;
        int current = map.get(array[array.length - 1]);
        stack.push(new Pair(array[array.length - 1], current));

        for (var i = array.length - 2; i >= 0; i--) {
            current = map.get(array[i]);

            while (!stack.isEmpty() && current >= stack.peek().freq) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek().data;
            stack.push(new Pair(array[i], current));
        }

        Arrays.stream(res).forEach(System.out::print);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 2, 11, 3, 3};

        NextGreaterFrequency nextGreaterFrequency = new NextGreaterFrequency(arr);
        nextGreaterFrequency.solution();
    }
}
