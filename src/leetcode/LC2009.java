package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/description/
 */
public class LC2009 {

    public static void main(String[] args) {
        LC2009 lc2009 = new LC2009();
        int[] array = {1, 2, 3, 5, 6};
        System.out.println(lc2009.solution(array));
    }

    /**
     * we need to first sort the array
     * Get the length of the array with only unique elements in it. No need to use set and
     * allocate new array again
     *
     * starting from the left side, we need to keep increasing the subarray size as long as the
     * difference between the element on right and element on left is < nums.length.
     * if this violates, we keep on increasing the left pointer till the condition is not violated
     * anymore. then we update the max length of the valid sub array found so far.
     *
     * The final result is the length of the array - max length of the valid subarray
     * @param nums
     * @return minimum number of operations needed to make the array continuous
     */
    public int solution(int[] nums) {
        Arrays.sort(nums);

        int uniqueLength = 1, maxLength = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueLength++] = nums[i];
            }
        }

        int left = 0, right;
        for (right = 0; right < uniqueLength; right++) {
            while (nums[right] - nums[left] >= nums.length) {
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return nums.length - maxLength;
    }
}

