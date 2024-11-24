import java.util.ArrayList;
import java.util.Collections;

public class MinHeapSimulator { // Heap Queries

    public int[] solve(int[][] operations) { // operations
        ArrayList<Integer> minHeap = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            int operationType = operations[i][0];
            int value = operations[i][1];

            if (operationType == 2) { // Insert operation
                minHeap.add(value);
                heapConstruct(minHeap, minHeap.size() - 1);
            } else { // Extract minimum operation
                if (minHeap.isEmpty()) {
                    result.add(-1); // If the heap is empty, return -1
                } else {
                    result.add(minHeap.get(0)); // Extract the root (minimum value)
                    minHeap.set(0, minHeap.get(minHeap.size() - 1)); // Replace root with last element
                    minHeap.remove(minHeap.size() - 1); // Remove the last element
                    heapify(minHeap, 0); // Restore heap property
                }
            }
        }

        // Convert the result list to an array to return
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    // Restores the heap property when inserting a new element
    public void heapConstruct(ArrayList<Integer> heap, int index) {
        while (index > 0 && heap.get((index - 1) / 2) > heap.get(index)) {
            Collections.swap(heap, (index - 1) / 2, index);
            index = (index - 1) / 2; // Move up the tree
        }
    }

    // Restores the heap property after removing the root element
    public void heapify(ArrayList<Integer> heap, int index) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;
        int smallest = index;
        int size = heap.size();

        if (leftChild < size && heap.get(leftChild) < heap.get(smallest)) {
            smallest = leftChild;
        }
        if (rightChild < size && heap.get(rightChild) < heap.get(smallest)) {
            smallest = rightChild;
        }
        if (smallest != index) {
            Collections.swap(heap, index, smallest);
            heapify(heap, smallest); // Recursively heapify the affected subtree
        }
    }

    public static void main(String[] args) {
        MinHeapSimulator heapSimulator = new MinHeapSimulator();

        // Test case 1
        int[][] operations1 = {
            {2, 10}, {2, 5}, {1, 0}, {2, 3}, {1, 0}, {1, 0}
        };
        // Explanation: Insert 10, insert 5, extract min (5), insert 3, extract min (3), extract min (10)
        int[] result1 = heapSimulator.solve(operations1);
        for (int res : result1) {
            System.out.print(res + " ");
        }
        System.out.println();

        // Test case 2
        int[][] operations2 = {
            {1, 0}, {2, 20}, {2, 15}, {1, 0}, {1, 0}
        };
        // Explanation: Extract from empty (-1), insert 20, insert 15, extract min (15), extract min (20)
        int[] result2 = heapSimulator.solve(operations2);
        for (int res : result2) {
            System.out.print(res + " ");
        }
        System.out.println();

        // Test case 3
        int[][] operations3 = {
            {2, 1}, {2, 2}, {2, 3}, {1, 0}, {1, 0}, {1, 0}, {1, 0}
        };
        // Explanation: Insert 1, 2, 3, extract min (1), extract min (2), extract min (3), extract from empty (-1)
        int[] result3 = heapSimulator.solve(operations3);
        for (int res : result3) {
            System.out.print(res + " ");
        }
    }
}

/*
### Intuition:
1. The problem simulates a **min-heap** where:
   - Operation `{2, X}` inserts `X` into the heap.
   - Operation `{1, 0}` extracts the smallest element from the heap (the root).
   - If the heap is empty during an extract operation, we return `-1`.

2. Key operations:
   - **Insertion**: Adds the new element to the end of the heap and restores the heap property by comparing the element with its parent and swapping if necessary.
   - **Extraction**: Removes the root (minimum element), replaces it with the last element, and then restores the heap property by comparing and swapping with children.

3. The `heapify` method is used after extraction to restore the heap property, and `heapConstruct` is used to ensure proper placement of an element after insertion.

### Example Walkthrough:
For the input `{{2, 10}, {2, 5}, {1, 0}, {2, 3}, {1, 0}, {1, 0}}`:
- Insert 10 → Heap: [10]
- Insert 5 → Heap: [5, 10]
- Extract min → Output: 5, Heap: [10]
- Insert 3 → Heap: [3, 10]
- Extract min → Output: 3, Heap: [10]
- Extract min → Output: 10, Heap: []

Output: `[5, 3, 10]`

Problem Description:

You have an empty min heap. You are given an array A consisting of N queries. Let P denote A[i][0] and Q denote A[i][1]. There are two types of queries:

P = 1, Q = -1 : Pop the minimum element from the heap.
P = 2, 1 <= Q <= 109 : Insert Q into the heap.

Return an integer array containing the answer for all the extract min operation. If the size of heap is 0, then extract min should return -1.



Problem Constraints

1 <= N <= 105

1 <= A[i][0] <= 2

1 <= A[i][1] <= 109 or A[i][1] = -1



Input Format

The only argument A is a 2D integer array



Output Format

Return an integer array



Example Input

Input 1:

A = [[1, -1], [2, 2], [2, 1], [1, -1]]
Input 2:

A = [[2, 5], [2, 3], [2, 1], [1, -1], [1, -1]]


Example Output

Output 1:

[-1, 1]
Output 2:

[1, 3]


Example Explanation

Explanation 1:

For the first extract operation the heap is empty so it gives -1. For the second extract operation the heap contains the elements 2 and 1. Extract min returns the element 1.
Explanation 2:

The heap contains the elements 5, 3 and 1. The first extract min operation gets the element 1 and the second operation gets the element 3.

*/ 
