import java.util.*;

public class KthLargestElement {
    /**
     * Finds the K-th largest element for each subarray [1 to i] in the given array.
     */
    public int[] solve(int K, int[] array) {
        int[] result = new int[array.length];
        List<Integer> minHeap = new ArrayList<>();

        // Pre-fill the heap with the first K-1 elements and set result to -1 for these indices
        for (int i = 0; i < K - 1; i++) {
            minHeap.add(array[i]);
            result[i] = -1;
        }

        // Process elements starting from the K-th position
        for (int i = K - 1; i < array.length; i++) {
            if (minHeap.size() < K) {
                // Add element to the heap and rebuild heap for initialization
                minHeap.add(array[i]);
                heapBuilder(minHeap); // Build the heap from scratch
                result[i] = (minHeap.size() < K) ? -1 : minHeap.get(0);
            } else {
                // If current element is larger than the smallest in the heap, replace it
                if (array[i] > minHeap.get(0)) {
                    minHeap.set(0, array[i]);
                    heapify(minHeap, 0); // Restore the heap property
                }
                result[i] = minHeap.get(0); // Assign the K-th largest element
            }
        }
        return result;
    }

    /**
     * Build a min-heap from a list of integers.
     * Used for the initial heap construction when filling up to size K.
     */
    public void heapBuilder(List<Integer> minHeap) {
        int n = minHeap.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(minHeap, i);
        }
    }

    /**
     * Restore the heap property for a min-heap starting from the given index.
     * Ensures that the subtree rooted at the index is a valid heap.
     */
    public void heapify(List<Integer> minHeap, int p) {
        int n = minHeap.size();
        int smallest = p;
        int lf = 2 * p + 1; // Left child index
        int rf = 2 * p + 2; // Right child index

        if (lf < n && minHeap.get(lf) < minHeap.get(smallest)) {
            smallest = lf;
        }
        if (rf < n && minHeap.get(rf) < minHeap.get(smallest)) {
            smallest = rf;
        }

        if (smallest != p) {
            Collections.swap(minHeap, smallest, p); // Swap and recursively heapify
            heapify(minHeap, smallest);
        }
    }
public static void main(String[] args) {
        KthLargestElement solver = new KthLargestElement();

        // Test case 1
        int K1 = 3;
        int[] array1 = {4, 2, 7, 1, 5, 3};
        System.out.println("Test Case 1: " + Arrays.toString(solver.solve(K1, array1))); // Expected: [-1, -1, 2, 4, 4, 4]

        // Test case 2
        int K2 = 2;
        int[] array2 = {10, 20, 11, 70, 50};
        System.out.println("Test Case 2: " + Arrays.toString(solver.solve(K2, array2))); // Expected: [-1, 10, 11, 20, 50]

        // Test case 3
        int K3 = 4;
        int[] array3 = {1, 2, 3, 4, 5, 6};
        System.out.println("Test Case 3: " + Arrays.toString(solver.solve(K3, array3))); // Expected: [-1, -1, -1, 1, 2, 3]

        // Test case 4
        int K4 = 1;
        int[] array4 = {6, 2, 9, 3, 7};
        System.out.println("Test Case 4: " + Arrays.toString(solver.solve(K4, array4))); // Expected: [6, 2, 9, 3, 7]
    }
    /**
     * Intuition:
     * For each subarray [1 : i], the goal is to find the K-th largest element efficiently.
     * Using a min-heap of size K, we maintain the top K largest elements seen so far.
     * - For indices < K, we add elements to the heap but return -1 as the result.
     * - From index K onwards:
     *   - If the current element is larger than the smallest in the heap, replace it.
     *   - The root of the heap (smallest element) represents the K-th largest element.
     *
     * Example:
     * Input: K = 3, array = [4, 2, 7, 1, 5, 3]
     * Process:
     * - Subarray [4]: Heap = [4], Result = [-1]
     * - Subarray [4, 2]: Heap = [2, 4], Result = [-1, -1]
     * - Subarray [4, 2, 7]: Heap = [2, 4, 7], Result = [-1, -1, 2]
     * - Subarray [4, 2, 7, 1]: Replace 2 -> Heap = [1, 4, 7], Result = [-1, -1, 2, 4]
     * - Subarray [4, 2, 7, 1, 5]: Replace 1 -> Heap = [4, 5, 7], Result = [-1, -1, 2, 4, 4]
     * - Subarray [4, 2, 7, 1, 5, 3]: No replacement, Result = [-1, -1, 2, 4, 4, 4]
     * Output: [-1, -1, 2, 4, 4, 4]
     */
    
    
}
