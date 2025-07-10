import java.util.*;

public class FractionalKnapsackSimple {

    public static double getMaxValue(int[] value, int[] weight, int capacity) {
        int n = value.length;

        // Step 1: Create 2D array to store value and weight of each item
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = value[i];    // value
            items[i][1] = weight[i];   // weight
        }

        // Step 2: Sort items by value-to-weight ratio (high to low)
        Arrays.sort(items, (a, b) -> {
            double ratioA = (double) a[0] / a[1];
            double ratioB = (double) b[0] / b[1];
            return Double.compare(ratioB, ratioA); // descending
        });

        // Step 3: Fill the knapsack greedily
        double totalValue = 0;
        int currentWeight = 0;

        for (int i = 0; i < n; i++) {
            int itemValue = items[i][0];
            int itemWeight = items[i][1];

            if (currentWeight + itemWeight <= capacity) {
                // Take whole item
                totalValue += itemValue;
                currentWeight += itemWeight;
            } else {
                // Take only the fraction that fits
                int remaining = capacity - currentWeight;
                totalValue += (double) itemValue * remaining / itemWeight;
                break; // bag is full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int capacity = 50;

        double result = getMaxValue(value, weight, capacity);
        System.out.println("Maximum value in knapsack = " + result);
    }
}

/*USING CUSTOM CLASS

import java.util.*;

public class FractionalKnapsackWithRatio {

    // Custom class to hold value, weight, and ratio
    static class Item {
        int value;
        int weight;
        double ratio;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight; // calculate once
        }
    }

    // Function to return maximum value that fits in the knapsack
    public static double getMaxValue(int[] value, int[] weight, int capacity) {
        int n = value.length;

        // Step 1: Create array of Item objects with ratio
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(value[i], weight[i]);
        }

        // Step 2: Sort items by ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;
        int currentWeight = 0;

        // Step 3: Greedily pick items based on ratio
        for (int i = 0; i < n; i++) {
            if (currentWeight + items[i].weight <= capacity) {
                // Take full item
                totalValue += items[i].value;
                currentWeight += items[i].weight;
            } else {
                // Take only the fraction that fits
                int remaining = capacity - currentWeight;
                totalValue += items[i].ratio * remaining;
                break; // knapsack is full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int capacity = 50;

        double result = getMaxValue(value, weight, capacity);
        System.out.println("Maximum value in knapsack = " + result);
    }
}
 */