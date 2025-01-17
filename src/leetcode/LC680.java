package leetcode;

public class LC680 {

    public boolean validPalindrome(String s) {
        // base case
        if (s == null || s.isEmpty()) {
            return false;
        }

        for (int i = 0, j = s.length() -1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                int i1 = i + 1, j1 = j, i2 = i, j2 = j - 1;

                while (i1 < j1 && s.charAt(i1) == s.charAt(j1)) {
                    i1++;
                    j1--;
                }
                if (i1 >= j1) {
                    return true;
                }

                while (i2 < j2 && s.charAt(i2) == s.charAt(j2)) {
                    i2++;
                    j2--;
                }

                return i2 >= j2;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LC680 lc680 = new LC680();
        System.out.println(lc680.validPalindrome("aba"));  // Output: true
        System.out.println(lc680.validPalindrome("abca"));  // Output: true
        System.out.println(lc680.validPalindrome("abc"));  // Output: false
    }
}
