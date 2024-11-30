public class MinPerfectSquares {
    // Method to count the minimum number of perfect squares that sum to A
    public int countMinSquares(int A) {
        int[] count = new int[A + 1]; // Array to store the minimum count for each number
        count[0] = 0; // Base case: 0 needs 0 perfect squares
        count[1] = 1; // Base case: 1 needs 1 perfect square (1 itself)
        
        for (int i = 2; i <= A; i++) {
            count[i] = i; // Initialize with the maximum count (1^2 + 1^2 + ... + 1^2 = i times)
            for (int j = 2; j * j <= i; j++) { 
                count[i] = Math.min(count[i], count[i - (j * j)] + 1); 
            }
        }
        return count[A]; // Return the minimum count for the number A
    }

    // Main method to test the countMinSquares function
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        System.out.println("Minimum squares for 12: " + MinPerfectSquares.countMinSquares(12)); // Expected: 3 (4+4+4)
        System.out.println("Minimum squares for 13: " + MinPerfectSquares.countMinSquares(13)); // Expected: 2 (9+4)
        System.out.println("Minimum squares for 17: " + MinPerfectSquares.countMinSquares(17)); // Expected: 2 (16+1)
    }
}

/*
Intuition for the Solution:
1. Dynamic programming is used to find the minimum number of perfect squares for every number from 0 to A.
2. For each number i, we consider all perfect squares less than or equal to i (e.g., 1, 4, 9, etc.).
3. If a perfect square j*j can be subtracted from i, then the remaining value i-(j*j) is looked up in the dp array.
4. The result for i is the minimum of all such values, plus one for the current perfect square.
5. Base cases:
   - count[0] = 0: No squares needed for 0.
   - count[1] = 1: Only 1 (1^2) is needed for 1.
6. Time Complexity:
   - Outer loop runs for A numbers, and the inner loop iterates over all possible perfect squares less than or equal to A.
   - This results in a complexity of O(A * sqrt(A)).
7. Space Complexity:
   - O(A) due to the dp array.
*/
