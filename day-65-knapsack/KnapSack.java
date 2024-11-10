import java.util.*;

public class KnapSack {

    public int solve(int[] A, int[] B, int C) {
        double result = 0;

        // Create a list of Item objects
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            items.add(new Item(A[i], B[i]));
        }

        // Sort items in descending order based on the ratio using a lambda expression
        items.sort(Comparator.comparingDouble((Item item) -> item.ratio).reversed());

        // Fill the knapsack
        for (Item item : items) {
            if (C >= item.weight) {
                // Take the whole item if capacity allows
                result += item.value;
                C -= item.weight;
            } else {
                // Take the fractional part if capacity is less than item weight
                result += item.ratio * C;
                break; // Knapsack is full, exit loop
            }
        }

        // Multiply by 100 and return the floored result
        return (int) Math.floor(result * 100);
    }

    public static void main(String[] args) {
        // Define the values and weights
        int[] A = { 1, 2, 3 }; // Values
        int[] B = { 3, 4, 5 }; // Weights
        int C = 17; // Capacity

        // Create a KnapSack object
        KnapSack knapsack = new KnapSack();

        // Call the solve method and print the result
        int result = knapsack.solve(A, B, C);
        System.out.println(result); // Output the result
    }

    // Nested Item class
    class Item {
        int value, weight;
        double ratio;

        Item(int v, int w) {
            value = v;
            weight = w;
            ratio = (double) value / weight; // Calculate the ratio as a double
        }
    }
}