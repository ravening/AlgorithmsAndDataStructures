package leetcode;

/**
 * https://leetcode.com/problems/remove-k-digits/solutions/88708/straightforward-java-solution-using-stack/
 */
public class LC402 {

    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !sb.isEmpty() && sb.charAt(sb.length() - 1) >= num.charAt(i)) {
                sb.setLength(sb.length() - 1);
                k--;
            }

            // dont insert leading 0
            if (!sb.isEmpty() || num.charAt(i) != '0') {
                sb.append(num.charAt(i));
            }
        }

        while (k > 0 && !sb.isEmpty()) {
            k--;
            sb.setLength(sb.length() - 1);
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String number = "1432219";
        int k =1;
        LC402 lc402 = new LC402();
        System.out.println(lc402.removeKdigits(number, k));
    }
}
