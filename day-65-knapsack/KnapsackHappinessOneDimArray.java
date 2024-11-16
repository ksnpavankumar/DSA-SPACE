public class KnapsackHappinessOneDimArray {
    public static void main(String[] args) {
        // Values (happiness)
        int[] A = {12, 20, 15, 6, 10};
        // Weights
        int[] B = {3, 6, 5, 2, 4};
        // Knapsack capacity
        int C = 8;

        // Initialize DP array
        int[] dp = new int[C + 1];

        // Process each item
        for (int i = 0; i < A.length; i++) {
            // Traverse capacities in reverse to ensure 0/1 property
            for (int w = C; w >= B[i]; w--) {
                dp[w] = Math.max(dp[w], A[i] + dp[w - B[i]]);
            }
        }

        // Maximum happiness for given capacity
        System.out.println("Maximum happiness: " + dp[C]);
    }

    /*
     * This program solves the 0/1 Knapsack problem using a 1D Dynamic Programming approach.
     * The goal is to find the maximum total value (happiness) that can be obtained by selecting 
     * items such that their total weight does not exceed the given knapsack capacity (C).
     * 
     * Parameters:
     * A[] - Array containing the values (happiness) of each item.
     * B[] - Array containing the weights of each item.
     * C - The knapsack's weight capacity.
     * 
     * Explanation of the approach:
     * 1. We initialize a DP array of size (C + 1) where dp[w] will store the maximum value 
     *    that can be achieved with a knapsack capacity of w.
     * 
     * 2. For each item (i from 0 to A.length), we process it and update the DP array. 
     *    We iterate over the possible knapsack capacities from C down to the item's weight (B[i]).
     *    This reverse iteration ensures that each item is only considered once per capacity, 
     *    which is crucial to maintain the 0/1 property (either pick the item entirely or exclude it).
     *    
     *    The key update is:
     *    dp[w] = Math.max(dp[w], A[i] + dp[w - B[i]])
     *    - Option 1: Include the item: Add its value (A[i]) and the maximum value that can 
     *      be achieved with the remaining capacity (dp[w - B[i]]).
     *    - Option 2: Exclude the item: The value remains the same as dp[w].
     * 
     * 3. After processing all items, dp[C] holds the maximum achievable value for the given 
     *    knapsack capacity C.
     * 
     * This approach uses a 1D array for dynamic programming, which reduces space complexity 
     * compared to the 2D array approach.
     */
}
