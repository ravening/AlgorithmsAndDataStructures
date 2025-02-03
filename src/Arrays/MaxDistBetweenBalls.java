package Arrays;

import java.util.Arrays;

/**
 * You have “n” empty baskets, you are given the position of the empty baskets in an array called "position", where position[i] specifies the position of the ith basket. Additionally you have m balls to be distributed among the n baskets, You have to distribute the m balls into n baskets such that the minimum magnetic force between any two balls is maximum.
 * The magnetic force between two different balls at position x and y is defined as |x-y|
 */
public class MaxDistBetweenBalls {

    /**
     * This is a Binary Search on Answer problem, where we aim to maximize the minimum magnetic force between any two balls while distributing them in baskets.
     *
     * Approach
     * 	1.	Sort the Basket Positions
     * Since the magnetic force is defined as the absolute difference between positions, sorting helps in placing the balls optimally.
     * 	2.	Use Binary Search on the Minimum Magnetic Force (d)
     * 	•	The minimum force between two balls should be as large as possible.
     * 	•	We perform binary search on d (the minimum force between two balls).
     * 	•	The range of d is between 1 (smallest possible gap) and max(position) - min(position) (largest possible gap).
     * 	3.	Check Feasibility Using Greedy Algorithm
     * 	•	We try to place m balls into the baskets such that the minimum distance is at least d.
     * 	•	Start placing the first ball in the first basket.
     * 	•	Place the next ball only if the gap from the last placed ball is at least d.
     * 	•	If we can place all m balls successfully, d is feasible, and we try a larger d.
     * @param positions
     * @param m
     * @return
     */
    public int maxDistance(int[] positions, int m) {
        int result = 0;
        Arrays.sort(positions);

        int left = 1, right = positions[positions.length - 1];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canPlaceBall(positions, m, mid)) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private boolean canPlaceBall(int[] positions, int m, int minDistance) {
        int prevPosition = positions[0];
        int ballsPaced = 1;

        for (var i = 1; i < positions.length; i++) {
            if (positions[i] - prevPosition >= minDistance) {
                ballsPaced++;
                prevPosition = positions[i];
            }
            if (ballsPaced == m) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] position = {5, 4, 3, 2, 1, 100}; // Basket positions
        int m = 2; // Number of balls

        MaxDistBetweenBalls solution = new MaxDistBetweenBalls();

        System.out.println(solution.maxDistance(position,m));
    }
}
