public class ContainerWithMostWater {
    public int findMaxWaterArea(int[] heights) { // Finds the maximum water container area
        int left = 0, right = heights.length - 1, maxArea = 0;

        // Two-pointer approach to calculate maximum area
        while (left < right) {
            int currentArea = Math.min(heights[left], heights[right]) * (right - left); // Calculate current area

            // Move the pointer at the smaller height
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }

            // Update maxArea if a larger area is found
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();

        // Example inputs
        int[] heights1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max water area: " + solution.findMaxWaterArea(heights1)); // Output: 49

        int[] heights2 = {1, 1};
        System.out.println("Max water area: " + solution.findMaxWaterArea(heights2)); // Output: 1

        int[] heights3 = {4, 3, 2, 1, 4};
        System.out.println("Max water area: " + solution.findMaxWaterArea(heights3)); // Output: 16

        int[] heights4 = {1, 2, 1};
        System.out.println("Max water area: " + solution.findMaxWaterArea(heights4)); // Output: 2
    }

    /*
     * Intuition:
     * - The problem is about finding the largest area formed by two vertical lines and the x-axis.
     * - To solve this efficiently, we use the two-pointer technique:
     *    1. Start with two pointers, one at the beginning (left) and the other at the end (right) of the array.
     *    2. Calculate the area formed by the lines at the two pointers and update the maximum area.
     *    3. Move the pointer pointing to the shorter line inward, because the height of the shorter line 
     *       limits the area, and moving it may increase the possibility of finding a taller line.
     *    4. Repeat until the pointers meet, ensuring all possible container combinations are checked.
     * - This approach works in O(n) time, as each pointer is moved at most once across the array.
     */

/*
 * Time Complexity: O(n)
 * - Two-pointer approach: Each pointer moves at most once across the array, resulting in linear time.
 * - Per iteration, constant operations (min, multiplication) are performed.
 * 
 * Space Complexity: O(1)
 * - Only a few variables (left, right, maxArea) are used, no extra data structures.
 * 
 * Efficiency:
 * - Scales well for large inputs due to linear traversal.
 * - Optimal compared to brute force O(n^2) approaches that check all pairs.
 */

}
