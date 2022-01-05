package Arrays;

/*
https://www.geeksforgeeks.org/longest-subsegment-1s-formed-changing-k-0s/
 */
public class LongestSubSeg {
    private int solution(int[] array, int k) {
        if (k >= array.length)
            return array.length;

        int left = 0;
        int count = 0;
        int maxlen = 0;

        for (var i = 0; i < array.length; i++) {
            if (array[i] == 0)
                count++;

            while (count > k) {
                if (array[left] == 0)
                    count--;
                left++;
            }

            maxlen = Math.max(maxlen, (i - left + 1));
        }

        return maxlen;
    }

    public static void main(String[] args) {
        LongestSubSeg longestSubSeg = new LongestSubSeg();
        int a[] = { 1, 0, 0, 1, 0, 1, 0, 1 };
        int k = 2;
        System.out.println(longestSubSeg.solution(a, k));
    }
}
