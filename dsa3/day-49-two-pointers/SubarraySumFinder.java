import java.util.Arrays;

public class SubarraySumFinder {
    public int[] findSubarrayWithSum(int[] nums, int target) {
        int i = 0, j = 0, sum = 0, n = nums.length;

        // Sliding window approach to find the subarray
        while (j < n) {
            sum += nums[j]; // Expand the window by including the current element

            // Shrink the window from the left if the sum exceeds the target
            while (sum > target && i <= j) {
                sum -= nums[i];
                i++;
            }

            // If the sum matches the target, return the subarray
            if (sum == target) {
                return Arrays.copyOfRange(nums, i, j + 1);
            }

            j++; // Move the window's right end forward
        }

        // Return [-1] if no subarray is found
        return new int[]{-1};
    }

    public static void main(String[] args) {
        SubarraySumFinder finder = new SubarraySumFinder();

        // Example test cases
        int[] result1 = finder.findSubarrayWithSum(new int[]{1, 2, 3, 4, 5}, 9);
        System.out.println(Arrays.toString(result1)); // Output: [2, 3, 4]

        int[] result2 = finder.findSubarrayWithSum(new int[]{1, 2, 3, 4, 5}, 15);
        System.out.println(Arrays.toString(result2)); // Output: [1, 2, 3, 4, 5]

        int[] result3 = finder.findSubarrayWithSum(new int[]{1}, 2);
        System.out.println(Arrays.toString(result3)); // Output: [-1]

        int[] result4 = finder.findSubarrayWithSum(new int[]{1}, 1);
        System.out.println(Arrays.toString(result4)); // Output: [1]
    }

    /*
     * Intuition:
     * - The goal is to find a contiguous subarray whose sum equals the target.
     * - Use the sliding window technique:
     *    1. Start with two pointers (`i` and `j`) at the beginning of the array.
     *    2. Expand the window by incrementing `j` and adding `nums[j]` to the sum.
     *    3. If the sum exceeds the target, shrink the window from the left by incrementing `i` and subtracting `nums[i]` from the sum.
     *    4. When the sum matches the target, the subarray from `i` to `j` is the result.
     * - This approach ensures every subarray is considered exactly once, achieving O(n) time complexity.
     * - Space complexity is O(1) as no extra data structures are used, aside from the result array.
     */
}
