import java.util.PriorityQueue;

public class SortNearlySortedArray {
    /**
     * Sorts a nearly sorted array where each element is at most `B` positions away
     * from its sorted position.
     *
     * @param A the input array
     * @param B the maximum distance of any element from its sorted position
     * @return the sorted array
     */
    public int[] sortNearlySorted(int[] A, int B) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int i = 0, j = 0;
        int n = A.length;
        int[] res = new int[n];

        // Add the first B elements to the heap
        while (i < B) {
            heap.add(A[i]);
            i++;
        }

        // Process the rest of the elements
        while (i < n) {
            heap.add(A[i]);
            i++;
            res[j] = heap.poll(); // Remove the smallest element from the heap
            j++;
        }

        // Empty the heap for remaining elements
        while (!heap.isEmpty()) {
            res[j] = heap.poll();
            j++;
        }

        return res;
    }

    // Main method for testing
    public static void main(String[] args) {
        SortNearlySortedArray solution = new SortNearlySortedArray();

        // Test case 1
        int[] arr1 = {6, 5, 3, 2, 8, 10, 9};
        int k1 = 3;
        int[] result1 = solution.sortNearlySorted(arr1, k1);
        System.out.println("Sorted array: " + java.util.Arrays.toString(result1)); // Expected: [2, 3, 5, 6, 8, 9, 10]

        // Test case 2
        int[] arr2 = {10, 9, 8, 7, 4, 70, 60, 50};
        int k2 = 4;
        int[] result2 = solution.sortNearlySorted(arr2, k2);
        System.out.println("Sorted array: " + java.util.Arrays.toString(result2)); // Expected: [4, 7, 8, 9, 10, 50, 60, 70]

        // Test case 3
        int[] arr3 = {2, 6, 3, 12, 56, 8};
        int k3 = 3;
        int[] result3 = solution.sortNearlySorted(arr3, k3);
        System.out.println("Sorted array: " + java.util.Arrays.toString(result3)); // Expected: [2, 3, 6, 8, 12, 56]
    }

    /*
     * Intuition:
     * The input array is "nearly sorted," meaning each element is at most `B`
     * positions away from its correct sorted position.
     *
     * 1. Use a min-heap (priority queue) to always keep the smallest `B + 1` elements
     *    in the heap (since an element's correct position can only be influenced by these).
     *
     * 2. Add the first `B` elements to the heap. Then for each new element from the array,
     *    add it to the heap and extract the smallest element, which must be at the current
     *    sorted position.
     *
     * 3. After processing all elements from the array, extract the remaining elements
     *    from the heap to complete the sorted order.
     *
     * This ensures the array is sorted efficiently, with a time complexity of O(n log B),
     * where `n` is the array size and `B` is the max distance.
     */
}
