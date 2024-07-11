package leetcode;

import java.util.Arrays;

/**
 * Solution Approach
 *
 * To solve this problem, we can use a binary search approach to determine the minimum eating speed k.
 *
 * 	1.	Define the Search Range:
 * 	•	The minimum possible eating speed k is 1 (Koko can eat at least one banana per hour).
 * 	•	The maximum possible eating speed k is the maximum number of bananas in any pile (in the worst case, Koko can eat an entire pile in one hour).
 * 	2.	Binary Search:
 * 	•	Use binary search to find the minimum eating speed.
 * 	•	For each candidate speed k, calculate the total hours Koko needs to eat all the bananas.
 * 	•	If the total hours required is less than or equal to h, then try a smaller speed to see if it’s possible to eat all bananas even slower.
 * 	•	If the total hours required is greater than h, then try a faster speed.
 * 	3.	Calculating Hours:
 * 	•	For each pile, calculate the hours needed to eat all bananas in that pile with speed k.
 * 	•	Use the formula hours = (pile + k - 1) / k to ensure that any leftover bananas count as an extra hour.
 *
 * Explanation
 *
 * 	1.	Binary Search Setup:
 * 	•	left starts at 1 (minimum possible speed).
 * 	•	right starts at the maximum number of bananas in any pile (maximum possible speed).
 * 	2.	Binary Search Loop:
 * 	•	Calculate the middle point mid of the current search range.
 * 	•	Use the helper function canFinish to check if Koko can finish eating all the bananas with speed mid within h hours.
 * 	•	If she can, adjust the search range to look for a potentially slower speed.
 * 	•	If she cannot, adjust the search range to look for a faster speed.
 * 	3.	canFinish Function:
 * 	•	Iterate through each pile and calculate the hours needed to eat all bananas in that pile with speed k.
 * 	•	Accumulate the total hours and compare with h.
 * 	•	If the total hours exceed h, return false; otherwise, return true.
 *
 * This binary search approach ensures an efficient solution to find the minimum eating speed within a logarithmic number of iterations relative to the size of the piles and their values.
 *
 * We use a binary search to find the minimum eating speed:
 *
 * 	•	mid is the middle point of the current search range.
 * 	•	canFinish(piles, h, mid) checks if Koko can eat all bananas with speed mid within h hours.
 * 	•	If she can (canFinish returns true), it means she might be able to do it even slower, so we adjust right to mid.
 * 	•	If she can’t (canFinish returns false), she needs to eat faster, so we adjust left to mid + 1.
 *
 * The loop continues until left equals right, which will be the minimum possible eating speed.
 *
 * The canFinish method determines if Koko can finish all bananas in h hours at a given speed k:
 *
 * 	•	hoursNeeded accumulates the total hours required.
 * 	•	For each pile, the time required to finish the pile at speed k is calculated as (pile + k - 1) / k. This is a trick to achieve the ceiling division without using floating-point arithmetic. It is equivalent to Math.ceil((double)pile / k).
 * 	•	If hoursNeeded exceeds h at any point, return false indicating Koko cannot finish at this speed.
 * 	•	If the loop completes without exceeding h, return true indicating Koko can finish at this speed.
 */
public class LC875 {

    public static void main(String[] args) {
        LC875 lc875 = new LC875();
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println(lc875.minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean canFinish(int[] piles, int h, int k) {
        int hoursNeeded = 0;

        for (var pile : piles) {
            hoursNeeded += (pile + k -1 ) / k;
            if (hoursNeeded > h) {
                return false;
            }
        }
        return true;
    }
}
