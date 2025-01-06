package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int answer = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int left = num - 1;
            int right = num + 1;

            while (set.remove(left)) {
                left--;
            }

            while (set.remove(right)) {
                right++;
            }

            answer = Math.max(answer, right - left - 1);

            if (set.isEmpty()) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        LC128 lc128 = new LC128();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(lc128.longestConsecutive(nums));  // Output: 4
    }
}
