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

/*
Intuition:
------------
1. This is a variation of the Fractional Knapsack problem where we want to maximize the total value we can carry.
2. Since we can take fractional parts of items, we sort items based on value/weight ratio in descending order.
3. We iterate through the sorted items and add them fully if they fit, otherwise, we take a fraction to fill up the remaining capacity.
4. This greedy approach ensures we always pick the most valuable (per weight) items first, leading to an optimal solution.

Time Complexity Analysis:
-------------------------
1. Creating the list of items: O(N)
2. Sorting the items based on value-to-weight ratio: O(N log N)
3. Iterating through the sorted list to fill the knapsack: O(N)
4. Overall, the total time complexity is: **O(N log N)** (due to sorting being the dominant step)

Space Complexity Analysis:
---------------------------
1. We use an extra list to store the item objects: O(N)
2. The sorting operation is in-place, so no extra sorting space is needed.
3. Overall, the total space complexity is: **O(N)**
*/
