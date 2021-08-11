package src.Arrays;// given an amount and coin, find the number of ways to make the amount using
// the coins


import java.util.Arrays;

public class CoinChangeDP {
    public void minimumCoins(int[] coins, int amount) {
        int[] table = new int[amount + 1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;
        for (var i = 1; i <= amount; i++) {
            for (var j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int tmp = table[i - coins[j]];
                    if (tmp != Integer.MAX_VALUE && (tmp + 1 < table[i])) {
                        table[i] = tmp + 1;
                    }
                }
            }
        }

        System.out.println(table[amount]);
    }

    public static void main(String[] args) {
        CoinChangeDP problem = new CoinChangeDP();
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        problem.minimumCoins(coins, amount);
    }
    public void solution(int[] values, int amount) {
        int[][] solution = new int[values.length+1][amount+1];

        // if there are no coins then there is no solution
        for (int i = 1; i <= amount; i ++) {
            solution[0][i] = 0;
        }

        // if the amount is 0 then return 1
        for (int i = 0; i < values.length; i++) {
            solution[i][0] = 1;
        }

        // now fill the remaining
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= amount; j++) {
                // if coin values is less than the amount
                if (values[i] < j) {
                    // solution is to include it and exclude it
                    solution[i][j] = solution[i-1][j] +
                            solution[i][j- values[i-1]];
                } else {
                    solution[i][j] = solution[i-1][j];
                }
            }
        }

        System.out.print(solution[values.length][amount]);
    }
}
