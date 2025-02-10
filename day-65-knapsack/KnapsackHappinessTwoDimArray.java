public class KnapsackHappinessTwoDimArray {
    
    /**
     * This function solves the 0/1 Knapsack problem using Dynamic Programming.
     * It calculates the maximum value (happiness) that can be achieved by selecting 
     * items such that the total weight does not exceed the given knapsack capacity (C).
     *
     * @param A Array containing the values (happiness) of each item.
     * @param B Array containing the weights of each item.
     * @param C Maximum weight capacity of the knapsack.
     * @return The maximum achievable value that can be obtained with the given knapsack capacity.
     */
    public int solve(int[] A, int[] B, int C) {
        int n = A.length;
        
        // Initialize the dp array where dp[i][j] stores the maximum value achievable
        // using the first i items with a knapsack capacity of j.
        int[][] dp = new int[n + 1][C + 1];

        // Iterate through all items (i from 1 to n) and all knapsack capacities (j from 0 to C)
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= C; j++) {
                // If the current item's weight is less than or equal to the current capacity,
                // two options are considered:
                if (j >= B[i - 1]) {
                    // Option 1: Include the item (add its value and remaining capacity)
                    dp[i][j] = Math.max(A[i - 1] + dp[i - 1][j - B[i - 1]], dp[i - 1][j]);
                } else {
                    // Option 2: Exclude the item (carry forward the maximum value from previous)
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The result will be in dp[n][C], representing the maximum value with n items
        // and knapsack capacity C.
        return dp[n][C];
    }

    public static void main(String[] args) {
        KnapsackHappinessTwoDimArray knapsack = new KnapsackHappinessTwoDimArray();

        // Test Case 1: Simple case where we can select all items
        int[] A1 = {60, 100, 120};
        int[] B1 = {10, 20, 30};
        int C1 = 50;
        System.out.println("Max Happiness (Test Case 1): " + knapsack.solve(A1, B1, C1));

        // Test Case 2: Case with a smaller capacity where only some items can be selected
        int[] A2 = {10, 20, 30};
        int[] B2 = {5, 10, 15};
        int C2 = 20;
        System.out.println("Max Happiness (Test Case 2): " + knapsack.solve(A2, B2, C2));

        // Test Case 3: Case where the knapsack capacity is very small and no item can be selected
        int[] A3 = {10, 15, 40};
        int[] B3 = {100, 200, 300};
        int C3 = 50;
        System.out.println("Max Happiness (Test Case 3): " + knapsack.solve(A3, B3, C3));

        // Test Case 4: Case where only one item is selected
        int[] A4 = {40, 50, 60};
        int[] B4 = {5, 5, 10};
        int C4 = 5;
        System.out.println("Max Happiness (Test Case 4): " + knapsack.solve(A4, B4, C4));
    }
}

/*
 * Explanation of the approach:

 * 1. **Dynamic Programming Array Initialization**:
 *    - The `dp[i][j]` table stores the maximum value (happiness) that can be achieved by selecting 
 *      the first `i` items with a knapsack capacity of `j`.
 *    
 * 2. **Main Loop**:
 *    - The outer loop iterates over each item (from 1 to `n`), and the inner loop iterates over 
 *      each possible knapsack capacity (from 0 to `C`).
 *    
 * 3. **Choices for Each Item**:
 *    - For each item, we consider two possible actions:
 *      a) **Include the item**: If the item can fit (i.e., its weight is less than or equal to the 
 *         current capacity), we add its value (`A[i-1]`) to the best value we could have achieved 
 *         with the remaining capacity (`dp[i-1][j - B[i-1]]`).
 *      b) **Exclude the item**: We keep the value from the previous row (`dp[i-1][j]`) without 
 *         including the current item.
 *      
 * 4. **Final Solution**:
 *    - The final result, representing the maximum happiness for `n` items and a knapsack capacity of `C`, 
 *      is stored in `dp[n][C]`.
 *    
 * By the end of the loops, `dp[n][C]` contains the maximum value (happiness) that can be achieved
 * without exceeding the knapsack's capacity, which is the answer to the problem.
 */
