package Trees;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/leaf-nodes-preorder-binary-search-tree/
 */
public class LeafNodesFromPreorder {
    public static void solution(int[] array) {
        Stack<Integer> stack = new Stack<>();

        boolean found;
        int i, j;
        for (i = 0, j =1; j < array.length; i++, j++) {
            found = false;

            if (array[i] > array[j]) {
                stack.push(array[i]);
            } else {
                while (!stack.isEmpty()) {
                    if (array[j] > stack.peek()) {
                        stack.pop();
                        found = true;
                    } else {
                        break;
                    }
                }
            }

            if (found)
                System.out.print(array[i]);
        }

        System.out.println(array[array.length - 1]);
    }
}
