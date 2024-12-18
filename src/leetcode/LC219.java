package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class LC219 {

    public static void main(String[] args) {
        LC219 lc219 = new LC219();
        int[] nums = {1,2,3,1};
        int k = 3;

        System.out.println(lc219.containsDuplication(nums, k));

        nums = new int[]{1,2,3,1,2,3};
        k = 2;
        System.out.println(lc219.containsDuplication(nums, k));
    }

    public boolean containsDuplication(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }

            if (!set.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}
