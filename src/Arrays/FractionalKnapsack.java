package Arrays;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/fractional-knapsack-problem/?ref=lbp
 */
public class FractionalKnapsack {
    static class Item {
        double weight;
        double value;
        Double cost;

        Item(double w, double v) {
            this.weight = w;
            this.value = v;
            this.cost = this.value / this.weight;
        }
    }

    private double solution(double[] weights, double[] values, double capacity) {
        Item[] items = new Item[weights.length];

        for (var i = 0; i < weights.length; i++) {
            items[i] = new Item(weights[i], values[i]);
        }

        Arrays.sort(items, (i1, i2) -> i2.cost.compareTo(i1.cost));

        double totalValue = 0;
        for (Item item : items) {
            double currentWeight = item.weight;
            double currentValue = item.value;

            if (capacity - currentWeight >= 0) {
                totalValue += currentValue;
                capacity -= currentWeight;
            } else {
                double fraction = capacity / currentWeight;
                double value = currentValue * fraction;
                totalValue += value;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        FractionalKnapsack fKnapsack =
                new FractionalKnapsack();

        double[] wt = { 10, 40, 20, 30 };
        double[] val = { 60, 40, 100, 120 };
        int capacity = 50;

        System.out.println(fKnapsack.solution(wt, val, capacity));
    }
}
