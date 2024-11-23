import java.util.ArrayList;
import java.util.Collections;

public class CuttingRopes {
    // Method to solve the optimal merge problem using a Min-Heap
    public int solve(ArrayList<Integer> A) { 
        int totalSum = 0;

        // Step 1: Build the Min-Heap
        buildHeap(A);  // Initializing the heap so the smallest elements are at the root

        // Step 2: Merge ropes until only one rope remains
        while (A.size() > 1) {
            // Extract the two smallest ropes
            int firstMin = A.get(0); // First smallest rope
            Collections.swap(A, 0, A.size() - 1); // Swap the root (smallest) with the last element
            A.remove(A.size() - 1); // Remove the smallest element (which is now at the end)
            heapify(A, 0); // Restore the heap property by reheapifying

            int secondMin = A.get(0); // Second smallest rope
            Collections.swap(A, 0, A.size() - 1); // Swap the root (second smallest) with the last element
            A.remove(A.size() - 1); // Remove the second smallest element
            heapify(A, 0); // Restore heap property again after removing the second element

            // Calculate the cost of merging the two smallest ropes
            int currentSum = firstMin + secondMin;
            totalSum += currentSum; // Add this cost to the total sum of merges

            // Insert the combined rope back into the heap
            A.add(currentSum);
            int index = A.size() - 1; // Position of the newly added combined rope

            // Restore the heap property after inserting the new element
            // We "bubble-up" the new element to its correct position in the heap
            while (index > 0 && A.get((index - 1) / 2) > A.get(index)) {
                Collections.swap(A, (index - 1) / 2, index); // Swap with the parent if needed
                index = (index - 1) / 2; // Move up to the parent index
            }
        }

        // After all merges, return the total cost
        return totalSum;
    }

    // Method to build the initial Min-Heap
    public void buildHeap(ArrayList<Integer> A) {
        int n = A.size();
        // Start from the last non-leaf node and heapify each node to ensure Min-Heap property
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(A, i); // Heapify each node starting from the last non-leaf node
        }
    }

    // Heapify function to restore the Min-Heap property
    public void heapify(ArrayList<Integer> A, int currentNode) {
        int n = A.size();
        int leftChild = 2 * currentNode + 1;
        int rightChild = leftChild + 1;
        int smallest = currentNode;

        // Compare with left child
        if (leftChild < n && A.get(leftChild) < A.get(smallest)) {
            smallest = leftChild; // If left child is smaller, make it the smallest
        }

        // Compare with right child
        if (rightChild < n && A.get(rightChild) < A.get(smallest)) {
            smallest = rightChild; // If right child is smaller, make it the smallest
        }

        // If the current node is already the smallest, no need to swap
        if (smallest == currentNode) {
            return;
        }

        // Swap the current node with the smallest of its children
        Collections.swap(A, currentNode, smallest);
        // Continue heapifying the affected subtree
        heapify(A, smallest);
    }

    // Test Cases
    public static void main(String[] args) {
        CuttingRopes solution = new CuttingRopes();

        // Test Case 1
        ArrayList<Integer> ropes1 = new ArrayList<>();
        ropes1.add(4);
        ropes1.add(3);
        ropes1.add(2);
        ropes1.add(6);
        System.out.println("Test Case 1: " + solution.solve(ropes1)); // Expected Output: 29

        // Test Case 2
        ArrayList<Integer> ropes2 = new ArrayList<>();
        ropes2.add(1);
        ropes2.add(2);
        ropes2.add(3);
        ropes2.add(4);
        ropes2.add(5);
        System.out.println("Test Case 2: " + solution.solve(ropes2)); // Expected Output: 33

        // Test Case 3
        ArrayList<Integer> ropes3 = new ArrayList<>();
        ropes3.add(1);
        ropes3.add(2);
        ropes3.add(3);
        System.out.println("Test Case 3: " + solution.solve(ropes3)); // Expected Output: 9

        // Test Case 4
        ArrayList<Integer> ropes4 = new ArrayList<>();
        ropes4.add(8);
        ropes4.add(4);
        ropes4.add(6);
        ropes4.add(12);
        System.out.println("Test Case 4: " + solution.solve(ropes4)); // Expected Output: 58
    }

    // Intuition and Example Reference (Binary Tree Analogy)
    /*
     * **Intuition Behind the Algorithm**:
     * - The algorithm follows a greedy approach to solve the optimal merge problem.
     * - We use a Min-Heap (a binary tree where the smallest element is at the root) to repeatedly merge the two smallest ropes.
     * - By always merging the smallest ropes first, we minimize the total cost of merging, which is the goal.
     * 
     * **Example**:
     * Consider the ropes: [4, 3, 2, 6]
     * 
     * Step 1: Build a Min-Heap.
     *      The Min-Heap tree looks like this:
     *  
     *        2
     *       / \
     *      3   4
     *     /
     *    6
     * 
     * Step 2: Merge the two smallest ropes:
     *      Merge 2 and 3, resulting in a rope of length 5.
     *      The total cost so far: 2 + 3 = 5
     *      Insert 5 back into the heap. Heap after merge:
     *  
     *        4
     *       / \
     *      5   6
     * 
     * Step 3: Merge the two smallest ropes again:
     *      Merge 4 and 5, resulting in a rope of length 9.
     *      The total cost so far: 5 + 9 = 14
     *      Insert 9 back into the heap. Heap after merge:
     *  
     *        6
     *       /
     *      9
     * 
     * Step 4: Merge the two smallest ropes one last time:
     *      Merge 6 and 9, resulting in a rope of length 15.
     *      The total cost so far: 14 + 15 = 29
     *      Now we only have one rope left, and the algorithm ends.
     * 
     * Final result: The minimum total cost is 29.
     * 
     * **Time Complexity**: O(n log n)
     *      - The heapify operation takes O(log n) time, and we perform it for each rope.
     *      - We perform O(n) heap operations (extracting two smallest ropes, merging them, and reinserting the combined rope).
     * 
     * **Space Complexity**: O(n)
     *      - We use space to store the ropes in the heap, which requires O(n) space.
     */
}
