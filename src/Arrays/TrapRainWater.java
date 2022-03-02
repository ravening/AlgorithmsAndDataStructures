// https://www.geeksforgeeks.org/trapping-rain-water/

package Arrays;

public class TrapRainWater {
    public int bestSolution(int[] array) {
        int n = array.length;
        int i = 0, j = n - 1;
        int result = 0;
        int lmax = 0, rmax = 0;
        while (i <= j) {
            if (lmax <= rmax) {
                result += Math.max(0, lmax - array[i]);
                lmax = Math.max(lmax, array[i]);
                i++;
            } else {
                result += Math.max(0, rmax - array[j]);
                rmax = Math.max(rmax, array[j]);
                j--;
            }
        }

        return result;
    }

    public void solution(int[] array) {
        int n = array.length;

        if (n == 0)
            return;

        int leftMax = 0, rightMax = 0;
        int low = 0, high = n -1;

        int result = 0;

        while (low < high) {
            if (array[low] < array[high]) {
                if (array[low] > leftMax) {
                    leftMax = array[low];
                } else {
                    result += leftMax - array[low];
                    low++;
                }
            } else {
                if (array[high] > rightMax) {
                    rightMax = array[high];
                } else {
                    result += rightMax - array[high];
                    high--;
                }
            }
        }

        System.out.println(result);
    }
}
