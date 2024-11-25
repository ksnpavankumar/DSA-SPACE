import java.util.PriorityQueue;

public class KSortedArrayHandler {
    public int[] sortKSortedArray(int[] array, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int i = 0, j = 0;
        int n = array.length;
        int[] result = new int[n];

        // Step 1: Add the first k elements to the heap
        while (i < k) {
            heap.add(array[i]);
            i++;
        }

        // Step 2: Process the remaining elements
        while (i < n) {
            heap.add(array[i]); // Add current element to the heap
            i++;
            result[j] = heap.poll(); // Remove and add the smallest element to the result
            j++;
        }

        // Step 3: Extract the remaining elements from the heap
        while (!heap.isEmpty()) {
            result[j] = heap.poll();
            j++;
        }

        return result;
    }

    // Main method to test the solution with various inputs
    public static void main(String[] args) {
        KSortedArrayHandler handler = new KSortedArrayHandler();

        // Test case 1: k = 2
        int[] array1 = {6, 5, 3, 2, 8, 10, 9};
        int k1 = 2;
        int[] result1 = handler.sortKSortedArray(array1, k1);
        System.out.println("Sorted Array (k=2): " + java.util.Arrays.toString(result1));

        // Test case 2: k = 3
        int[] array2 = {10, 9, 8, 7, 4, 70, 60, 50};
        int k2 = 3;
        int[] result2 = handler.sortKSortedArray(array2, k2);
        System.out.println("Sorted Array (k=3): " + java.util.Arrays.toString(result2));

        // Test case 3: k = 0 (already sorted array)
        int[] array3 = {1, 2, 3, 4, 5};
        int k3 = 0;
        int[] result3 = handler.sortKSortedArray(array3, k3);
        System.out.println("Sorted Array (k=0): " + java.util.Arrays.toString(result3));

        // Test case 4: Single element array
        int[] array4 = {1};
        int k4 = 0;
        int[] result4 = handler.sortKSortedArray(array4, k4);
        System.out.println("Sorted Array (k=0): " + java.util.Arrays.toString(result4));
    }
}

/*
Intuition:
- A k-sorted array means each element is at most k positions away from its correct sorted position.
- We use a min-heap to keep track of the smallest elements within a sliding window of size k+1.
- Steps:
  1. Initialize the heap with the first k elements.
  2. For every new element, add it to the heap and extract the smallest element to maintain order.
  3. After processing all elements in the array, extract the remaining elements from the heap to complete the sorting.
- The time complexity is O(n log k), where n is the size of the array and k is the size of the heap.
*/
