import java.util.ArrayList;
import java.util.Collections;

public class KSortedArraySorter {
    public ArrayList<Integer> sortKSortedArray(ArrayList<Integer> array, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> minHeap = new ArrayList<>();

        // Step 1: Build the initial heap with the first k+1 elements
        for (int i = 0; i <= k && i < array.size(); i++) {
            minHeap.add(array.get(i));
        }
        buildHeap(minHeap);

        // Step 2: Process remaining elements
        for (int i = k + 1; i < array.size(); i++) {
            result.add(minHeap.get(0)); // Extract the smallest element
            minHeap.set(0, array.get(i)); // Replace root with the next element
            heapify(minHeap, 0); // Restore heap property
        }

        // Step 3: Extract remaining elements from the heap
        while (!minHeap.isEmpty()) {
            result.add(minHeap.get(0)); // Add the root to the result
            minHeap.set(0, minHeap.get(minHeap.size() - 1)); // Replace root with last element
            minHeap.remove(minHeap.size() - 1); // Remove last element
            if (!minHeap.isEmpty()) {
                heapify(minHeap, 0); // Restore heap property
            }
        }

        return result; // Return the sorted array
    }

    // Helper method to build the initial min-heap
    private void buildHeap(ArrayList<Integer> minHeap) {
        int n = minHeap.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(minHeap, i);
        }
    }

    // Helper method to restore heap property
    private void heapify(ArrayList<Integer> minHeap, int index) {
        int left = 2 * index + 1;
        int right = left + 1;
        int smallest = index;
        int n = minHeap.size();

        if (left < n && minHeap.get(left) < minHeap.get(smallest)) {
            smallest = left;
        }
        if (right < n && minHeap.get(right) < minHeap.get(smallest)) {
            smallest = right;
        }
        if (smallest != index) {
            Collections.swap(minHeap, smallest, index);
            heapify(minHeap, smallest);
        }
    }

    // Main method to test the solution with various inputs
    public static void main(String[] args) {
        KSortedArraySorter sorter = new KSortedArraySorter();

        // Test case 1: k = 2
        ArrayList<Integer> array1 = new ArrayList<>();
        Collections.addAll(array1, 6, 5, 3, 2, 8, 10, 9);
        System.out.println("Sorted Array (k=2): " + sorter.sortKSortedArray(array1, 2));

        // Test case 2: k = 3
        ArrayList<Integer> array2 = new ArrayList<>();
        Collections.addAll(array2, 10, 9, 8, 7, 4, 70, 60, 50);
        System.out.println("Sorted Array (k=3): " + sorter.sortKSortedArray(array2, 3));

        // Test case 3: k = 0 (already sorted array)
        ArrayList<Integer> array3 = new ArrayList<>();
        Collections.addAll(array3, 1, 2, 3, 4, 5);
        System.out.println("Sorted Array (k=0): " + sorter.sortKSortedArray(array3, 0));

        // Test case 4: Single element array
        ArrayList<Integer> array4 = new ArrayList<>();
        Collections.addAll(array4, 1);
        System.out.println("Sorted Array (k=0): " + sorter.sortKSortedArray(array4, 0));
    }
}

/*
Intuition:
- A k-sorted array means each element is at most k positions away from its correct sorted position.
- A min-heap is ideal for maintaining the smallest elements efficiently.
- We use a sliding window of size (k+1) to maintain the heap:
  1. Add the first k+1 elements to the heap and build it.
  2. Process remaining elements by replacing the root of the heap (smallest element) with the next element in the array and heapifying.
  3. Extract remaining elements from the heap to finalize the sorted array.
- This approach ensures sorting is efficient and works well for k-sorted arrays with a time complexity of O(n log k).
*/
