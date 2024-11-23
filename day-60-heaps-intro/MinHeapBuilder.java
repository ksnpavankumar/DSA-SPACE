class MinHeapBuilder {

    /**
     * Builds a min-heap from the given array.
     * The array will be rearranged in place to satisfy the min-heap property.
     *
     * @param A the array to be turned into a min-heap
     * @return the array after being transformed into a min-heap
     */
    public int[] buildHeap(int[] A) {
       buildHeapHelper(A);  // Start the process of building the min-heap from the bottom up
       return A;
    }

    /**
     * Helper method to build the min-heap by calling heapify on each non-leaf node.
     * It starts from the last non-leaf node and moves towards the root.
     *
     * @param A the array representing the heap
     */
    public void buildHeapHelper(int[] A){
        int n = A.length;
        // Start from the last non-leaf node and move upwards
        for(int i = n / 2 - 1; i >= 0; i--){
            heapify(A, i);  // Ensure the heap property is satisfied for each node
        }
    }

    /**
     * Heapifies the tree rooted at the given node to ensure the min-heap property.
     * It compares the node with its children and swaps if necessary, then continues
     * the heapify process until the subtree is a valid heap.
     *
     * @param A the array representing the heap
     * @param node the index of the node to heapify
     */
    public void heapify(int[] A, int node){
        int n = A.length;
        while(true){
            int lf = node * 2 + 1;  // Left child index
            int rf = lf + 1;         // Right child index
            int smallest = node;     // Assume the node is the smallest initially
            
            // Check if the left child exists and is smaller than the current node
            if(lf < n && A[lf] < A[node]){
                smallest = lf;
            }

            // Check if the right child exists and is smaller than the smallest so far
            if(rf < n && A[rf] < A[smallest]){
                smallest = rf;
            }

            // If the node is already the smallest, no need to swap
            if(node == smallest){
                break;
            }

            // Swap the current node with the smallest of its children
            swap(A, node, smallest);
            node = smallest;  // Move down the tree and heapify further
        }
    }

    /**
     * Swaps two elements in the array.
     *
     * @param A the array
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        MinHeapBuilder builder = new MinHeapBuilder();

        // Test cases with different input arrays
        int[] A1 = {3, 5, 1, 10, 2, 7};
        int[] A2 = {4, 6, 9, 3, 2, 8};
        int[] A3 = {15, 30, 10, 5, 20, 25, 35};

        // Printing out the min-heaps built from the input arrays
        System.out.println("Min-Heap for A1: ");
        printArray(builder.buildHeap(A1));

        System.out.println("Min-Heap for A2: ");
        printArray(builder.buildHeap(A2));

        System.out.println("Min-Heap for A3: ");
        printArray(builder.buildHeap(A3));
    }

    /**
     * Prints the elements of the array.
     * 
     * @param A the array to be printed
     */
    private static void printArray(int[] A) {
        for(int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}

/* Binary Tree Diagram for a Min-Heap
 *
 * Example min-heap after building the heap from the array [3, 5, 1, 10, 2, 7]:
 *
 *       1
 *     /   \
 *    2     3
 *   / \   /
 *  10  5 7
 *
 * The min-heap property is maintained such that the parent node is always smaller than or equal to its children.
 */

/*
 * Time Complexity:
 * The `buildHeapHelper` method runs a loop from n/2 - 1 to 0, and for each node, the `heapify` operation runs in O(log n) time.
 * Therefore, the overall time complexity is O(n), as the total number of operations is proportional to the size of the array.
 *
 * Space Complexity:
 * The space complexity is O(1) as the heap is built in place without using additional data structures.
 */
