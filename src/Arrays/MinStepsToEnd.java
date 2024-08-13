/*
https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/
 */
package Arrays;

public class MinStepsToEnd {
    int[] array;

    public MinStepsToEnd(int[] array) {
        this.array = array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }


    public static void main(String[] args) {
        int arr[] = new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        MinStepsToEnd minStepsToEnd = new MinStepsToEnd(arr);

        int arr1[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        minStepsToEnd.setArray(arr1);
        System.out.println(minStepsToEnd.solution(arr1));

        System.out.println(minStepsToEnd.solution(arr));

    }


    /**
     * The main idea is based on greedy.
     * Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the farthest point that all points
     * in [curBegin, curEnd] can reach. Once the current point reaches curEnd, then trigger another jump, and set the
     * new curEnd with curFarthest, then keep the above steps, as the following:
     * @param nums
     * @return
     */
    public int solution(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int curEnd = 0, curFarthest = 0, jumps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);

            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }

        return jumps;
    }
}
