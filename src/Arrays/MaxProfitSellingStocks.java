package src.Arrays;

/*
https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-stock-at-most-twice-set-2/?ref=rp
 */
public class MaxProfitSellingStocks {
    public void solution(int[] array) {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int profit1 = 0, profit2 = 0;

        for (int j : array) {
            buy1 = Math.min(buy1, j);

            profit1 = Math.max(profit1, j - buy1);

            buy2 = Math.min(buy2, j - profit1);

            profit2 = Math.max(profit2, j - buy2);
        }
    }

    public int solution2(int[] array) {
        int maxProfit = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i-1]) {
                maxProfit += (array[i] - array[i-1]);
            }
        }

        return maxProfit;
        
    }

    public static void main(String[] args) {
        MaxProfitSellingStocks profit = new MaxProfitSellingStocks();
        int[] array = { 100, 180, 260, 310, 40, 535, 695 };
        System.out.println(profit.solution2(array));
    }
}
