import java.util.ArrayList;

public class RectangleAreaCounter {

    /*
     * Problem:
     * Given a sorted array of distinct integers A and an integer B,
     * find and return how many distinct rectangles can be created using elements of the array 
     * as length and breadth, where the area of the rectangle is strictly less than B.
     * A rectangle formed by sides A[i] and A[j] is considered distinct from A[j] and A[i].
     * 
     * Example 1:
     * Input: A = [1, 2, 3, 4, 5], B = 5
     * Output: 8
     * Explanation: The valid pairs (i, j) are:
     * (1, 2), (1, 3), (1, 4), (1, 5), (2, 3), (2, 4), (3, 4), (3, 5)
     *
     * Example 2:
     * Input: A = [1, 3, 5, 7], B = 15
     * Output: 6
     * Explanation: The valid pairs are:
     * (1, 3), (1, 5), (1, 7), (3, 5), (3, 7), (5, 7)
     *
     * Approach:
     * 1. Use a two-pointer technique to find pairs that satisfy the area condition.
     * 2. Start with the left pointer `l` at the start and the right pointer `r` at the end of the array.
     * 3. If the area formed by A[l] * A[r] is less than B, all elements from A[l] to A[r] can form valid rectangles with A[l].
     *    We then move the left pointer to the next element.
     * 4. If the area is not less than B, we move the right pointer to the left.
     * 5. The answer is the count of valid rectangles modulo 10^9 + 7 to avoid overflow.
     * 
     * Time Complexity:
     * The time complexity is O(n), where n is the length of the array A. We process each element once.
     * Space Complexity:
     * O(1), since we only use two pointers and a few variables.
     */
    
    public int countRectanglesWithAreaLessThanB(ArrayList<Integer> lengths, int maxArea) {
        long answer = 0;
        long mod = 1000000007;  // Modulo to prevent overflow and fit in a 32-bit integer.
        int left = 0, right = lengths.size() - 1;

        while (left < lengths.size() && right >= 0) {
            if ((long) lengths.get(left) * lengths.get(right) < maxArea) {
                // If lengths[left] * lengths[right] < maxArea, all rectangles from A[left] to A[right] are valid.
                answer = (answer + (right + 1)) % mod;  // Count all valid rectangles with the current left side.
                left++;
            } else {
                right--;  // Decrease the right pointer if the area is not valid.
            }
        }

        return (int) answer;
    }

    // Main method to test different inputs
    public static void main(String[] args) {
        Solution solution = new Solution();

        ArrayList<Integer> testArray1 = new ArrayList<>();
        testArray1.add(1);
        testArray1.add(2);
        testArray1.add(3);
        testArray1.add(4);
        testArray1.add(5);

        int B1 = 5;
        System.out.println("Test Case 1:");
        System.out.println("Input: A = [1, 2, 3, 4, 5], B = " + B1);
        System.out.println("Output: " + solution.countRectanglesWithAreaLessThanB(testArray1, B1));  // Expected: 8

        ArrayList<Integer> testArray2 = new ArrayList<>();
        testArray2.add(1);
        testArray2.add(3);
        testArray2.add(5);
        testArray2.add(7);

        int B2 = 15;
        System.out.println("Test Case 2:");
        System.out.println("Input: A = [1, 3, 5, 7], B = " + B2);
        System.out.println("Output: " + solution.countRectanglesWithAreaLessThanB(testArray2, B2));  // Expected: 6
    }
}
