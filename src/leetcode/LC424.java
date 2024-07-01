package leetcode;

public class LC424 {
    public static void main(String[] args) {
        LC424 lc424 = new LC424();
        System.out.println(lc424.solution("ABAB", 2));
    }

    public int solution(String s, int k) {
        int[] array = new int[26];
        int i = 0, j, max = 0;
        int maxFrequency = 0;
        for (j = 0; j < s.length(); j++) {
            array[s.charAt(j) - 'A']++;
            maxFrequency = Math.max(maxFrequency, array[s.charAt(j) - 'A']);

            if ((j - i + 1) - maxFrequency > k) {
                array[s.charAt(i) - 'A']--;
                i++;
            }

            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}
