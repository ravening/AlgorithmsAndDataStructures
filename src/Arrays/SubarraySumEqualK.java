package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
 */
public class SubarraySumEqualK {

    public int solution(int[] array, int target) {
        int n = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        int curSum = 0, result = 0;
        map.put(0, 1);

        for (var i = 0 ; i < n; i++) {
            curSum += array[i];

            result += map.getOrDefault(curSum - target, 0);

            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }

        return  result;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 2, -2, -20, 10 };
        int sum = -10;
        SubarraySumEqualK subarraySumEqualK = new SubarraySumEqualK();
        System.out.println(subarraySumEqualK.solution(arr, sum));
    }
}
