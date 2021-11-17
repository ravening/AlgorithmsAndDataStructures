package Strings;

public class CheckBalancedParanthesis {
    String input;
    int k;

    CheckBalancedParanthesis(String s, int x) {
        this.input = s;
        this.k = x;
    }

    private boolean solution() {
        boolean valid = true;
        if (input.length() %2 != 0)
            return false;

        int count = 0;

        for (var ch : input.toCharArray()) {
            if (ch == '(') {
                count++;
            } else {
                count--;
            }
        }

        if (count != 0) {
            return false;
        }

        count = 0;
        int ans = 0;

        for (var ch : input.toCharArray()) {
            if (ch == '(') {
                count++;
            } else {
                count--;

                if (count < 0) {
                    count = 0;
                    ans++;
                }
            }
        }

        return ans <= k;
    }

    public static void main(String[] args) {
        CheckBalancedParanthesis checkBalancedParanthesis =
                new CheckBalancedParanthesis(")()((", 1);

        System.out.println(checkBalancedParanthesis.solution());
    }
}
