package leetcode;

public class LC2645 {

    public static void main(String[] args) {
        LC2645 lc2645 = new LC2645();
        System.out.println(lc2645.addMinimum("abc"));
        System.out.println(lc2645.addMinimum("ab"));
        System.out.println(lc2645.addMinimum("a"));
        System.out.println(lc2645.addMinimum("b"));
        System.out.println(lc2645.addMinimum("c"));
        System.out.println(lc2645.addMinimum("abca"));
    }

    public int addMinimum(String word) {
        int answer = 0;
        int i = 0;
        String abc = "abc";
        while (i < word.length()) {
            for (char ch : abc.toCharArray()) {
                if (i < word.length() && word.charAt(i) == ch) {
                    i++;
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }
}
