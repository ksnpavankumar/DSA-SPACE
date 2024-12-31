import java.util.Arrays;

public class PairDifferenceFinder {
    
    /*
     * Problem:
     * Given a one-dimensional integer array A of size N and an integer B, 
     * count all distinct pairs (x, y) such that the absolute difference between x and y equals B.
     *
     * A pair is defined as (x, y), where x and y are numbers from the array A, 
     * and the condition |x - y| = B holds true. The pair (x, y) is considered distinct 
     * if x != y, and order doesn't matter (i.e., (x, y) is the same as (y, x)).
     *
     * Constraints:
     * 1 <= N <= 10^4
     * 0 <= A[i], B <= 10^5
     *
     * Approach:
     * 1. Sort the array to enable efficient pair search using the two-pointer technique.
     * 2. Use two pointers, one starting from the left and one starting from the right.
     * 3. Move the pointers based on the current difference between the elements they point to.
     * 4. If the difference is equal to B, count the pair and skip any duplicate elements.
     * 5. Continue moving the pointers until all valid pairs are found.
     */
    
    public int countPairsWithDifference(int[] numbers, int targetDifference) {
        // Sort the array to use the two-pointer technique
        Arrays.sort(numbers);
        
        int left = 0, right = 1, n = numbers.length, count = 0;

        while (right < n) {
            int difference = numbers[right] - numbers[left];
            int leftValue = numbers[left], rightValue = numbers[right];

            if (difference == targetDifference) {
                // Found a pair with the target difference
                count++;
                // Skip over duplicates of leftValue and rightValue
                while (left < n && numbers[left] == leftValue) left++;
                while (right < n && numbers[right] == rightValue) right++;
            } else if (difference < targetDifference) {
                // Increase the difference by moving the right pointer
                right++;
            } else {
                // Decrease the difference by moving the left pointer
                left++;
            }

            // Ensure that the right pointer is always ahead of the left pointer
            if (left == right) {
                right++;
            }
        }

        return count;
    }

    // Intuition and Example:
    /*
     * This method uses the two-pointer technique to find all pairs of elements in the array
     * whose absolute difference equals the targetDifference. The array is first sorted, 
     * and then two pointers are used to explore potential pairs. 
     *
     * For each pair (numbers[left], numbers[right]), if the difference between the numbers
     * is equal to the targetDifference, we count it as a valid pair and skip over any duplicate 
     * elements. If the difference is less than the target, we move the right pointer to increase 
     * the difference. If the difference is greater, we move the left pointer to decrease the 
     * difference. 
     *
     * The time complexity is O(n log n) due to the sorting, and O(n) for the two-pointer traversal.
     * Thus, the overall time complexity is O(n log n).
     *
     * Example 1:
     * Input: numbers = [1, 2, 3, 4, 5], targetDifference = 2
     * Output: 3
     * Explanation: The pairs with difference 2 are (1, 3), (2, 4), (3, 5).
     *
     * Example 2:
     * Input: numbers = [1, 1, 2, 3, 3], targetDifference = 1
     * Output: 4
     * Explanation: The pairs with difference 1 are (1, 2), (2, 3), (3, 4) (handling duplicates).
     */

    public static void main(String[] args) {
        PairDifferenceFinder finder = new PairDifferenceFinder();
        
        // Example 1: Expected output is 3
        int[] numbers1 = {1, 2, 3, 4, 5};
        int targetDifference1 = 2;
        System.out.println("Example 1 result: " + finder.countPairsWithDifference(numbers1, targetDifference1));
        
        // Example 2: Expected output is 4
        int[] numbers2 = {1, 1, 2, 3, 3};
        int targetDifference2 = 1;
        System.out.println("Example 2 result: " + finder.countPairsWithDifference(numbers2, targetDifference2));
        
        // Example 3: Expected output is 2
        int[] numbers3 = {1, 3, 5, 7, 9};
        int targetDifference3 = 2;
        System.out.println("Example 3 result: " + finder.countPairsWithDifference(numbers3, targetDifference3));
        
        // Example 4: Expected output is 3
        int[] numbers4 = {2, 3, 6, 7, 9};
        int targetDifference4 = 3;
        System.out.println("Example 4 result: " + finder.countPairsWithDifference(numbers4, targetDifference4));
        
        // Example 5: Expected output is 0 (no pairs with difference 10)
        int[] numbers5 = {1, 3, 5, 7, 9};
        int targetDifference5 = 10;
        System.out.println("Example 5 result: " + finder.countPairsWithDifference(numbers5, targetDifference5));
    }
}
