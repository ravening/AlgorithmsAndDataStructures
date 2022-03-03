package Arrays;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station-set-2-map-based-approach/
 */
public class MinimumPlatforms {
    public int solution(int[] arrival, int[] departure) {
        int[] array = new int[2361];
        Arrays.fill(array, 0);
        int max = 1;

        for (var i = 0; i < arrival.length; i++) {
            ++array[arrival[i]];
            --array[departure[i]];
        }

        for (var i =1; i < 2361; i++) {
            array[i] = array[i] + array[i-1];
            max = Math.max(max, array[i]);
        }

        return max;
    }
}
