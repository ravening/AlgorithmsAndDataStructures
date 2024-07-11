package leetcode;

/**
 * “Minimize Max Distance to Gas Station,” involves finding the optimal position for additional gas stations such that
 * the maximum distance between adjacent gas stations is minimized.
 *
 * Problem Description
 *
 * You are given:
 *
 * 	•	A list stations which represents the positions of gas stations along a highway.
 * 	•	An integer k, which is the number of additional gas stations you are allowed to add.
 *
 * Your goal is to minimize the maximum distance between adjacent gas stations after adding the k new stations.
 *
 * Solution Approach
 *
 * To solve this problem, we can use a binary search approach on the maximum possible distance between gas stations.
 * This is a typical example of a problem where binary search on the answer can be used.
 *
 * Steps to Implement the Solution
 *
 * 	1.	Define the Search Range:
 * 	•	The minimum possible distance is 0 (though in practice it will be a small positive number).
 * 	•	The maximum possible distance is the difference between the two farthest existing stations.
 * 	2.	Binary Search on Distance:
 * 	•	For a given candidate distance d, check if it is possible to add k or fewer gas stations such that no two adjacent gas stations are more than d units apart.
 * 	3.	Feasibility Check:
 * 	•	For each gap between existing stations, calculate the number of additional stations needed to ensure the gap is no larger than d.
 * 	•	Sum up the required additional stations for all gaps and check if it is within the allowed k.
 *
 * 	Explanation
 *
 * 	1.	Binary Search Setup:
 * 	•	left starts at 0 (minimum possible distance).
 * 	•	right starts at the maximum distance between the first and last station.
 * 	2.	Binary Search Loop:
 * 	•	mid is the middle point of the current search range.
 * 	•	canPlaceStations(stations, k, mid) checks if it’s possible to add k or fewer stations such that the maximum distance between adjacent stations is at most mid.
 * 	•	If it’s possible, we try to find a smaller maximum distance by adjusting right to mid.
 * 	•	If it’s not possible, we need to increase the allowed distance by adjusting left to mid.
 * 	3.	Feasibility Check:
 * 	•	canPlaceStations calculates how many additional stations are needed for each gap between consecutive stations to ensure the gap is no larger than d.
 * 	•	If the total required stations are within the allowed k, it returns true.
 * 	4.	Precision Threshold:
 * 	•	The loop continues until the difference between left and right is less than a small epsilon value (1e-6), ensuring the result is precise.
 *
 * Key Points
 *
 * 	•	Binary Search on the Answer: This technique efficiently narrows down the possible maximum distance by iteratively testing feasible values.
 * 	•	Feasibility Function: The function canPlaceStations is crucial to determine if a given distance d is achievable with the allowed number of additional stations.
 *
 */
public class LC774 {

    public static void main(String[] args) {
        int[] stations = {23,24,36,39,46,56,57,65,84,98};
        int k = 1;
        LC774 lc774 = new LC774();
        System.out.println(lc774.minMaxDistance(stations, k));
    }

    public int minMaxDistance(int[] stations, int k) {
        int left = 0;
        int right = stations[stations.length - 1] - stations[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canPlaceStation(stations, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canPlaceStation(int[] stations, int k, int mid) {
        int count = 0;
        if (mid == 0) {
            return true;
        }

        for (int i = 1; i < stations.length; i++) {
            int diff = stations[i] - stations[i - 1];
            count += (int)(diff / mid);
        }

        return count <= k;
    }
}
