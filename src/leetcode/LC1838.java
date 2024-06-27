package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/frequency-of-the-most-frequent-element/solutions/1175088/c-maximum-sliding-window-cheatsheet-template/
public class LC1838 {

    public static void main(String[] args) {
        int[] nums = {2,4,1};
        int k = 5;

        LC1838 lc1838 = new LC1838();
        System.out.println(lc1838.maxFrequency(nums, k));
    }

    /**
     *
     * @param nums
     * @param k
     * @return max frequency of the max repeating element
     *
     * logic is, (value of the element at the right side of the window * count of elements in the window) minus
     * the total sum of the elements in the window should be less than k. if not we reduce the current sum by the
     * element at the left of window and we increment the left pointer. at the end we return, difference of
     * right and left pointer
     */
    public int maxFrequency(int[] nums, int k) {
        int i = 0, j = 0, sum = 0;
        Arrays.sort(nums);
        for (; j < nums.length; j++) {
            sum += nums[j];

            if ((long)(j - i + 1) * nums[j] - sum > k) {
                sum -= nums[i++];
            }
        }

        return j - i;
    }
}
