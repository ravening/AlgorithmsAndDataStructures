package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1679 {

    public int maxOperations(int[] nums, int k) {
        int count  = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (var num : nums) {
            int result = k - num;

            if (map.containsKey(result) && map.get(result) > 0) {
                count++;
                map.put(result, map.get(result) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        LC1679 lc1679 = new LC1679();
        int[] nums = {1, 2, 3, 4};
        int k = 5;
        System.out.println(lc1679.maxOperations(nums, k));  // Output: 2

        nums = new int[]{3, 1, 3, 4, 3};
        k = 6;
        System.out.println(lc1679.maxOperations(nums, k));  // Output: 1
    }
}
