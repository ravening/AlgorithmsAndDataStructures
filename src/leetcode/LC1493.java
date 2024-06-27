package leetcode;

//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/solutions/708112/JavaC++Python-Sliding-Window-at-most-one-0/
public class LC1493 {

    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};
        LC1493 solution = new LC1493();
        System.out.println(solution.maxLength(nums));
        System.out.println(solution.longestSubarray(nums));

        int[] array = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(solution.longestSubarray(array, 3));
    }

    public int maxLength(int[] nums) {
        int i = 0, j, length = 0, k = 1;

        for (j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                k--;
            }

            while (k < 0) {
                if (nums[i] == 0) {
                    k++;
                }

                i++;
            }

            length = Math.max(length, j - i);
        }

        return length;
    }

    public int longestSubarray(int[] A) {
        int i = 0, j, k = 1;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) k--;
            if (k < 0 && A[i++] == 0) k++;
        }
        return j - i - 1;
    }

//    https://leetcode.com/problems/max-consecutive-ones-iii/solutions/247564/JavaC++Python-Sliding-Window/
    public int longestSubarray(int[] A, int k) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) k--;
            if (k < 0 && A[i++] == 0) k++;
        }
        return j - i ;
    }
}
