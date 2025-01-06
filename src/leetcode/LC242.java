package leetcode;

public class LC242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (var i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LC242 lc242 = new LC242();
        System.out.println(lc242.isAnagram("anagram", "nagaram"));  // Output: true
        System.out.println(lc242.isAnagram("rat", "car"));  // Output: false
    }
}
