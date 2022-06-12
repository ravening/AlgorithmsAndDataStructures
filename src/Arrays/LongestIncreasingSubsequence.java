package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://www.geeksforgeeks.org/construction-of-longest-increasing-subsequence-using-dynamic-programming/
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {3,2,4,5,1};
        solution(arr);
        lisCount(arr);

        arr = new int[]{10, 22, 9, 33, 21, 50, 41, 60};
        solution(arr);
        lisCount(arr);
        maxIncreasingSum(arr);
    }

    public static void maxIncreasingSum(int[] array) {
        int[] dp = new int[array.length];
        for (var i = 0; i < array.length; i++) {
            dp[i] = array[i];
        }

        for (var i = 1; i < array.length; i++) {
            for (var j = 0 ; j < i; j++) {
                if (array[i] > array[j] && (dp[i] < dp[j] + array[i])) {
                    dp[i] = dp[j] + array[i];
                }
            }
        }

        int max = 0;
        for (var x : dp) {
            max = Math.max(max,x);
        }

        System.out.println(max);
    }
    public static void lisCount(int[] array) {
        int[] dp = new int[array.length];
        int i=0, j=0, max = 0;

        Arrays.fill(dp, 1);

        for (i = 1; i < array.length; i++) {
            for (j = 0; j < i; j++) {
                if (array[i] > array[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        for (var x : dp) {
            if (x > max) {
                max = x;
            }
        }

        System.out.println(max);
    }

    public static void betterSolution(int[] array) {
        List<Integer>[] lists = new List[array.length];

        for (var i = 0; i < array.length; i++) {
            lists[i] = new ArrayList<>();
        }

        lists[0].add(array[0]);

        for (var i = 1; i < array.length; i++) {
            for (var j = 0; j < i; j++) {
                if (array[i] > array[j] && lists[i].size() < lists[j].size() + 1) {
                    lists[i].clear();
                    lists[i].addAll(lists[i]);
                }
            }
            lists[i].add(array[i]);
        }

        int max = lists[0].size();
        List<Integer> maxList = lists[0];

        for (var i = 1; i < array.length; i++) {
            if (lists[i].size() > max) {
                max = lists[i].size();
                maxList = lists[i];
            }
        }
        maxList.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public static void solution(int[] array) {
        List<ArrayList<Integer>> lis = new ArrayList<>();
        for (var i =0; i < array.length; i++) {
            lis.add(new ArrayList<>());
        }

        lis.get(0).add(array[0]);
        for (var i = 1; i < array.length; i++) {
            for (var j = 0; j < i; j++) {
                if (array[i] > array[j] && lis.get(i).size() < lis.get(j).size() + 1) {
                    lis.get(i).clear();
                    lis.get(i).addAll(lis.get(j));
                }
            }

            lis.get(i).add(array[i]);
        }

        int max = lis.get(0).size();
        List<Integer> list = lis.get(max);
        for (var i = 1; i < lis.size(); i++) {
            if (lis.get(i).size() > max) {
                list = lis.get(i);
                max = lis.get(i).size();
            }
        }

        list.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }
}
