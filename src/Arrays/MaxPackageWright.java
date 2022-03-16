package Arrays;

/*
https://leetcode.com/discuss/interview-question/1747893/Amazon-OA-2022-or-SDE-1
 */
public class MaxPackageWright {
    public int solution(int[] array) {
        int length = array.length;
        int left = length - 2, right = length - 1;

        while (left >= 0) {
            if (array[left] < array[right]) {
                array[left] += array[right];
            }
            left--;
            right--;
        }

        int max = 0;
        for (var i : array) {
            max = Math.max(max, i);
        }

        return max;
    }
}
