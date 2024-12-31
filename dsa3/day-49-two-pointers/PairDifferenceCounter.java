import java.util.HashSet;

public class PairDifferenceCounter {

    /*
     * Problem:
     * Given a one-dimensional integer array A of size N and an integer B,
     * count all distinct pairs (x, y) such that the absolute difference |x - y| = B.
     * A pair (x, y) is considered distinct if x != y and order does not matter (i.e., (x, y) is the same as (y, x)).
     *
     * Constraints:
     * 1 <= N <= 10^4
     * 0 <= A[i], B <= 10^5
     *
     * Approach:
     * - Use a HashSet to track the elements we have encountered so far.
     * - For each element in the array, check if either (num + B) or (num - B) exists in the set.
     * - If either exists, then a valid pair has been found. Add the pair in sorted order to a HashSet to ensure uniqueness.
     * - The size of the HashSet containing pairs gives the count of distinct pairs.
     * 
     * Time Complexity: O(N) - We iterate through the array once, and HashSet operations (add, contains) are O(1) on average.
     *
     * Example 1:
     * Input: A = [1, 5, 3, 4, 2], B = 2
     * Steps:
     * - First, add 1 to the set.
     * - Then, for each number, check if either num + 2 or num - 2 exists in the set.
     * - If found, add the pair (x, y) in sorted order to the `uniquePairs` set.
     * - At the end, the `uniquePairs` will contain (1, 3), (3, 5), and (2, 4), resulting in a count of 3.
     * Output: 3

     * Example 2:
     * Input: A = [1, 1, 2, 2, 3], B = 1
     * Steps:
     * - First, add 1 to the set.
     * - Then, for each number, check if num + 1 or num - 1 exists in the set.
     * - At the end, the `uniquePairs` will contain (1, 2), (2, 3), resulting in a count of 2.
     * Output: 2

     * Example 3:
     * Input: A = [5, 5, 5, 5], B = 0
     * Steps:
     * - For every number, check if it is equal to another number (difference = 0).
     * - All pairs of 5s form valid pairs.
     * Output: 1 (Only one distinct pair of (5, 5) despite multiple occurrences)
     * 
     * Example 4:
     * Input: A = [1, 2, 3, 4, 5], B = 1
     * Steps:
     * - First, add 1 to the set.
     * - Then, for each number, check if num + 1 or num - 1 exists in the set.
     * - At the end, the `uniquePairs` will contain (1, 2), (2, 3), (3, 4), (4, 5), resulting in a count of 4.
     * Output: 4
     */

    public int countDistinctPairsWithDifference(int[] A, int B) {
        // HashSet to store unique elements encountered so far
        HashSet<Integer> elements = new HashSet<>();
        // HashSet to track distinct pairs, stored in sorted order to avoid duplicates
        HashSet<String> uniquePairs = new HashSet<>();

        for (int num : A) {
            // Check if (num + B) or (num - B) exists in the set
            if (elements.contains(num + B)) {
                // Add pair in sorted order to ensure (x, y) is the same as (y, x)
                uniquePairs.add(Math.min(num, num + B) + ":" + Math.max(num, num + B));
            }
            if (elements.contains(num - B)) {
                // Add pair in sorted order to ensure (x, y) is the same as (y, x)
                uniquePairs.add(Math.min(num, num - B) + ":" + Math.max(num, num - B));
            }
            // Add current element to the set
            elements.add(num);
        }

        // The size of the uniquePairs set gives the count of distinct pairs
        return uniquePairs.size();
    }

    // Example usages:
    public static void main(String[] args) {
        PairDifferenceCounter counter = new PairDifferenceCounter();
        
        // Example 1: Expected output is 3
        int[] A1 = {1, 5, 3, 4, 2};
        int B1 = 2;
        System.out.println("Example 1 result: " + counter.countDistinctPairsWithDifference(A1, B1));
        
        // Example 2: Expected output is 2
        int[] A2 = {1, 1, 2, 2, 3};
        int B2 = 1;
        System.out.println("Example 2 result: " + counter.countDistinctPairsWithDifference(A2, B2));
        
        // Example 3: Expected output is 1
        int[] A3 = {5, 5, 5, 5};
        int B3 = 0;
        System.out.println("Example 3 result: " + counter.countDistinctPairsWithDifference(A3, B3));
        
        // Example 4: Expected output is 4
        int[] A4 = {1, 2, 3, 4, 5};
        int B4 = 1;
        System.out.println("Example 4 result: " + counter.countDistinctPairsWithDifference(A4, B4));
    }
}
