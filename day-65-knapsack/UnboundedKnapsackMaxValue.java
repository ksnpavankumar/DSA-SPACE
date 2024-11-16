public class UnboundedKnapsackMaxValue {
    public static void main(String[] args) {
        // Knapsack capacity
        int A = 8;

        // Values array (happiness or profit of each item)
        int[] B = {12, 20, 15};

        // Weights array (weight of each item)
        int[] C = {2, 3, 5};

        // Initialize DP array to store maximum value for each capacity
        int[] dp = new int[A + 1];

        // Process each item
        for (int i = 0; i < B.length; i++) {
            // Traverse capacities from the item's weight to the knapsack capacity
            for (int j = C[i]; j <= A; j++) {
                dp[j] = Math.max(dp[j], dp[j - C[i]] + B[i]);
            }
        }

        // Maximum value achievable for capacity A
        System.out.println("Maximum value: " + dp[A]);
    }

    /* 
     * Explanation and Walkthrough with Diagram:
     * 
     * Problem Summary:
     * - We are solving the Unbounded Knapsack problem, where you can pick unlimited instances of each item.
     * - Goal: Maximize the total value (profit/happiness) for a knapsack of capacity `A`.
     * - Inputs:
     *   1. `A`: The knapsack's total capacity.
     *   2. `B`: An array of values for each item.
     *   3. `C`: An array of weights for each item.
     * - Output: Maximum value achievable with a knapsack of capacity `A`.
     * 
     * Approach:
     * - Use Dynamic Programming (DP) with a 1D array.
     * - Define `dp[w]`: The maximum value achievable for a knapsack of weight `w`.
     * - Update formula:
     *   dp[j] = max(dp[j], dp[j - C[i]] + B[i])
     *   - Either skip the item: `dp[j]`
     *   - Or take the item: Add its value `B[i]` to the value achievable for the remaining capacity `j - C[i]`.
     * 
     * 
     * Diagram (Example Walkthrough):
     * ------------------------------
     * Inputs:
     * - Knapsack capacity: A = 8
     * - Values: B = [12, 20, 15]
     * - Weights: C = [2, 3, 5]
     * 
     * Steps:
     * 1. Initialize `dp[]`: [0, 0, 0, 0, 0, 0, 0, 0, 0]
     * 
     * Processing Item 1 (Value: 12, Weight: 2):
     * - For j = 2 to 8, update dp[j]:
     *   dp = [0, 0, 12, 12, 24, 24, 36, 36, 48]
     * 
     * Processing Item 2 (Value: 20, Weight: 3):
     * - For j = 3 to 8, update dp[j]:
     *   dp = [0, 0, 12, 20, 24, 32, 36, 44, 48]
     * 
     * Processing Item 3 (Value: 15, Weight: 5):
     * - For j = 5 to 8, update dp[j]:
     *   dp = [0, 0, 12, 20, 24, 32, 36, 44, 48]
     * 
     * Final Answer:
     * - Maximum value for capacity 8 is dp[8] = 48.
     * 
     * 
     * Evolution of dp[] during processing:
     * -------------------------------------
     * Initial dp[]:   [ 0   0   0   0   0   0   0   0   0 ]
     * After Item 1:   [ 0   0  12  12  24  24  36  36  48 ]
     * After Item 2:   [ 0   0  12  20  24  32  36  44  48 ]
     * After Item 3:   [ 0   0  12  20  24  32  36  44  48 ]
     * 
     * Explanation of each step in the diagram:
     * - "Initial dp[]": Represents an empty knapsack (no items considered).
     * - "After Item 1": Adding multiple instances of Item 1 (value = 12, weight = 2).
     * - "After Item 2": Considering Item 2 (value = 20, weight = 3), maximizing dp values.
     * - "After Item 3": Considering Item 3 (value = 15, weight = 5), no further updates here.
     */
}
