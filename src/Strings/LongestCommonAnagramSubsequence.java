package src.Strings;// https://www.geeksforgeeks.org/longest-common-anagram-subsequence/
// given two string, find the longest common anagram subsequence

public class LongestCommonAnagramSubsequence {
    public void solution(String str1, String str2) {
        int size = 26;
        int[] arr1 = new int[size];
        int[] arr2 = new int[size];

        for (int i = 0; i < str1.length(); i++) {
            arr1[str1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            arr2[str2.charAt(i) - 'a']++;
        }

        int len = 0;
        for (int i = 0; i < size; i++) {
            len += Math.min(arr1[i] , arr2[i]);
        }
    }
}
