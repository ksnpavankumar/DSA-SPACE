public class PairSumCounter {
    
    /*
     * Problem:
     * Given a sorted array of integers (not necessarily distinct) A and an integer B, 
     * find and return how many pairs of integers (A[i], A[j]) such that i != j have a sum equal to B.
     *
     * Since the number of such pairs can be very large, return the number of such pairs modulo (10^9 + 7).
     *
     * Constraints:
     * 1 <= |A| <= 100000
     * 1 <= A[i] <= 10^9
     * 1 <= B <= 10^9
     *
     * Approach:
     * 1. Use a two-pointer approach to efficiently find pairs in a sorted array.
     * 2. The left pointer starts at the beginning of the array and the right pointer starts at the end.
     * 3. Calculate the sum of the values at the two pointers and compare it with B.
     * 4. If the sum equals B, count the pairs.
     * 5. If the sum is less than B, move the left pointer to the right to increase the sum.
     * 6. If the sum is greater than B, move the right pointer to the left to decrease the sum.
     * 7. Ensure that we handle duplicates and avoid counting the same pair multiple times.
     * 8. Return the result modulo (10^9 + 7).
     */
    
    public int countPairsWithSum(int[] sortedArray, int targetSum) {
        int mod = 1000000007;
        int left = 0, right = sortedArray.length - 1;
        long pairCount = 0;

        while (left < right) {
            long sum = sortedArray[left] + sortedArray[right];

            if (sum == targetSum) {
                if (sortedArray[left] == sortedArray[right]) {
                    // If both elements are equal, calculate the number of pairs from duplicates
                    long numElements = right - left + 1;
                    long numPairs = (numElements * (numElements - 1)) / 2; // Combination of numElements choose 2
                    pairCount = (pairCount + numPairs) % mod;
                    break; // All pairs are counted, so we can stop
                } else {
                    // Count duplicates for sortedArray[left]
                    int leftCount = 1;
                    while (left < right && sortedArray[left] == sortedArray[left + 1]) {
                        left++;
                        leftCount++;
                    }
                    // Count duplicates for sortedArray[right]
                    int rightCount = 1;
                    while (left < right && sortedArray[right] == sortedArray[right - 1]) {
                        right--;
                        rightCount++;
                    }
                    pairCount = (pairCount + (long) leftCount * rightCount) % mod;
                    left++;
                    right--;
                }
            } else if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }

        return (int) pairCount;
    }

    // Intuition and Example:
    /*
     * This method uses a two-pointer technique to efficiently find all pairs of elements in the sorted array
     * whose sum equals the target sum. The array is sorted, and two pointers are used to explore potential pairs.
     *
     * For each pair (sortedArray[left], sortedArray[right]), if the sum equals the target sum, we count it 
     * as a valid pair and skip over any duplicate elements to avoid counting the same pair multiple times.
     *
     * If the sum is less than the target, we move the left pointer to the right to increase the sum.
     * If the sum is greater than the target, we move the right pointer to the left to decrease the sum.
     *
     * The time complexity of the solution is O(n), where n is the length of the array, as we only traverse the 
     * array once. The sorting step is O(n log n), but the two-pointer traversal ensures that we efficiently find pairs.
     * 
     * Example 1:
     * Input: sortedArray = [1, 2, 2, 3, 4], targetSum = 5
     * Output: 2
     * Explanation: The pairs with sum 5 are (1, 4) and (2, 3).
     *
     * Example 2:
     * Input: sortedArray = [1, 1, 2, 2, 3, 3], targetSum = 4
     * Output: 4
     * Explanation: The pairs with sum 4 are (1, 3), (1, 3), (2, 2), and (2, 2) (handling duplicates).
     */

    public static void main(String[] args) {
        PairSumCounter counter = new PairSumCounter();
        
        // Example 1: Expected output is 2
        int[] array1 = {1, 2, 2, 3, 4};
        int targetSum1 = 5;
        System.out.println("Example 1 result: " + counter.countPairsWithSum(array1, targetSum1));
        
        // Example 2: Expected output is 4
        int[] array2 = {1, 1, 2, 2, 3, 3};
        int targetSum2 = 4;
        System.out.println("Example 2 result: " + counter.countPairsWithSum(array2, targetSum2));
        
        // Example 3: Expected output is 1
        int[] array3 = {1, 3, 5, 7, 9};
        int targetSum3 = 10;
        System.out.println("Example 3 result: " + counter.countPairsWithSum(array3, targetSum3));
        
        // Example 4: Expected output is 3
        int[] array4 = {2, 3, 5, 5, 6};
        int targetSum4 = 8;
        System.out.println("Example 4 result: " + counter.countPairsWithSum(array4, targetSum4));
        
        // Example 5: Expected output is 0 (no pairs with sum 20)
        int[] array5 = {1, 3, 5, 7, 9};
        int targetSum5 = 20;
        System.out.println("Example 5 result: " + counter.countPairsWithSum(array5, targetSum5));
    }
}
