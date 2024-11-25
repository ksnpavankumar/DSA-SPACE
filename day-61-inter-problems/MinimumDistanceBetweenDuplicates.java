import java.util.HashMap;

public class MinimumDistanceBetweenDuplicates {
    /**
     * Finds the minimum distance between two identical elements in an array.
     *
     * @param A the input array
     * @return the minimum distance between two duplicate elements, or -1 if no duplicates exist
     */
    public int findMinDistanceBetweenDuplicates(int[] A) {
        int minDistance = Integer.MAX_VALUE; // Initialize with a large value
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Traverse through the array
        for (int i = 0; i < A.length; i++) {
            // If the element is already seen
            if (map.containsKey(A[i])) {
                int firstOcc = map.get(A[i]);
                // Update the minimum distance if a smaller one is found
                minDistance = Math.min(minDistance, i - firstOcc);
            } else {
                // If not seen, store the index of the element
                map.put(A[i], i);
            }
        }
        
        // If no duplicates are found, return -1
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    // Main method for testing
    public static void main(String[] args) {
        MinimumDistanceBetweenDuplicates solution = new MinimumDistanceBetweenDuplicates();
        
        // Test case 1
        int[] arr1 = {1, 2, 3, 4, 2};
        System.out.println(solution.findMinDistanceBetweenDuplicates(arr1)); // Expected output: 2

        // Test case 2
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(solution.findMinDistanceBetweenDuplicates(arr2)); // Expected output: -1

        // Test case 3
        int[] arr3 = {1, 2, 3, 4, 1, 2};
        System.out.println(solution.findMinDistanceBetweenDuplicates(arr3)); // Expected output: 1

        // Test case 4
        int[] arr4 = {1, 1, 1, 1};
        System.out.println(solution.findMinDistanceBetweenDuplicates(arr4)); // Expected output: 1
    }

    /*
     * Intuition:
     * The task is to find the minimum distance between two identical elements in the array.
     * 
     * 1. Use a hash map to keep track of the first occurrence index of each element.
     *    - The key will be the element, and the value will be the index of its first occurrence.
     * 2. As we traverse the array, for each element:
     *    - If it has appeared before, calculate the difference between the current index and
     *      the stored index (first occurrence) and update the minimum distance.
     *    - If it hasn't appeared before, store its index in the map.
     * 3. Finally, if we find a minimum distance, return it. If no duplicates are found, return -1.
     * 
     * Time Complexity: O(n), where n is the length of the array. We traverse the array once and
     * perform constant-time operations (hash map lookups and insertions) during each iteration.
     * 
     * Space Complexity: O(n), as we store each unique element and its index in the hash map.
     */
}
