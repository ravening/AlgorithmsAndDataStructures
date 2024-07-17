package leetcode;

/**
 * https://leetcode.com/problems/custom-sort-string/description/
 */
public class LC791 {

    public static void main(String[] args) {
        LC791 lc791 = new LC791();
        String order = "bcafg";
        String word = "abcd";

        System.out.println(lc791.solution(order, word));
    }

    public String solution(String order, String word) {
        int[] count = new int[26];

        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : order.toCharArray()) {
            while (count[ch - 'a']-- > 0) {
                sb.append(ch);
            }
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            while (count[ch - 'a']-- > 0) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
