package leetcode;

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/solutions/5555960/easy-one-pass-o-1-space-solution-c-python-java/?envType=daily-question&envId=2024-08-05
 */
public class LC1653 {

    public int minimumDeletions(String s) {
        int result = 0, count = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                count++;
            } else if (count != 0) {
                result++;
                count--;
            }
        }

        return result;
    }
}
