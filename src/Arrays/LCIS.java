package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://www.geeksforgeeks.org/longest-common-increasing-subsequence-lcs-lis/?ref=rp
 */
public class LCIS {
    public int lcisCount(int[] array1, int[] array2) {
        int[] dp = new int[array2.length];
        Arrays.fill(dp, 0);

        for (var i = 0; i < array1.length; i++) {
            int current = 0;
            for (var j = 0; j < array2.length; j++) {
                // if these two elements are same then we found lcs
                if (array1[i] == array2[j]) {
                    if (dp[j] < current + 1) {
                        dp[j] = current + 1;
                    }
                }

                // if element of arry1 is greater than array2 then we found lis
                if (array1[i] > array2[j]) {
                    if (current < dp[j]) {
                        current = dp[j];
                    }
                }
            }
        }

        int max = 0;

        for (int j : dp) {
            max = Math.max(max, j);
        }

        return max;
    }

    public void lcis(int[] array1, int[] array2) {
        List[] dp = new List[array2.length];
        Arrays.fill(dp, new ArrayList<>());

        List<Integer> max = new ArrayList<>();
        for (var i = 0; i < array1.length; i++) {
            int current = 0;
            for (var j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    if (max.size() == 0)
                        max.add(array1[i]);
                    if (array1[i] > max.get(max.size() - 1)) {
                        max.add(array1[i]);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int arr1[] = {3, 4, 9, 1};
        int arr2[] = {5, 3, 8, 9, 10, 2, 1};

        LCIS lcis = new LCIS();
        System.out.println(lcis.lcisCount(arr1, arr2));
    }
}
