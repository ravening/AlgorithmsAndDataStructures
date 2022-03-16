package Strings;

import java.util.Stack;

public class RemoveAdjacentDuplicate {
    public static void main(String[] args) {
        RemoveAdjacentDuplicate removeAdjacentDuplicate = new RemoveAdjacentDuplicate();

        String s = "abbaca";
        s = "deeedbbcccbdaa";
        System.out.println(removeAdjacentDuplicate.removeAdjacentDuplicate(s));
        System.out.println(removeAdjacentDuplicate.betterSolution(s));
        System.out.println(removeAdjacentDuplicate.removeAdjacentDuplicates2(s, 3));
    }

    /*
    https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/discuss/294893/JavaC++Python-Two-Pointers-and-Stack
     */
    public String betterSolution(String s) {
        char[] array = s.toCharArray();
        int i =0, j = 0;

        for (; j < array.length; ++j, ++i) {
            array[i] = array[j];

            if (i > 0 && array[i] == array[i-1]) {
                i -= 2;
            }
        }

        return String.valueOf(array, 0, i);
    }

    /*
    https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/discuss/392933/JavaC%2B%2BPython-Two-Pointers-and-Stack-Solution
     */
    public String removeAdjacentDuplicates2(String s, int k) {
        int length = s.length();
        int[] count = new int[length];
        char[] result = s.toCharArray();
        int i = 0, j = 0;

        if (length < k) {
            return s;
        }

        for (; j < length; ++j, ++i) {
            result[i] = result[j];
            count[i] = (i > 0 && result[i-1] == result[j]) ? count[i-1] + 1 : 1;
            if (count[i] == k) {
                i -= k;
            }
        }

        return String.valueOf(result, 0, i);
    }
    public String removeAdjacentDuplicate(String s) {
        if (s == null || s.equals(""))
            return "";

        Stack<Character> stack = new Stack<>();

        for (var i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder("");

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return reverseString(sb.toString());
    }

    public String reverseString(String s) {
        char[] array = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char ch = array[left];
            array[left] = array[right];
            array[right] = ch;
            left++;
            right--;
        }

        return new String(array);
    }
}
