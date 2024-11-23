import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectingRopesPriorityQueue {
    public int solve(ArrayList<Integer> A) {
        int ts = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(A);
        while (!pq.isEmpty()) {
            int first = pq.poll(); // Remove and get the smallest element
            int second = pq.poll(); // Remove and get the second smallest element
            int cs = first + second; // Calculate the cost of combining the ropes
            ts += cs; // Add the current cost to the total sum
            if (!pq.isEmpty()) {
                pq.add(cs); // Add the combined rope back to the priority queue
            }
        }
        return ts; // Return the total cost
    }

    public static void main(String[] args) {
        // Create an instance of the ConnectingRopesPriorityQueue class
        ConnectingRopesPriorityQueue solution = new ConnectingRopesPriorityQueue();
        
        // Test cases
        ArrayList<Integer> ropes1 = new ArrayList<>();
        ropes1.add(4);
        ropes1.add(3);
        ropes1.add(2);
        ropes1.add(6);
        System.out.println("Minimum cost for ropes1: " + solution.solve(ropes1)); // Expected output: 29

        ArrayList<Integer> ropes2 = new ArrayList<>();
        ropes2.add(1);
        ropes2.add(2);
        ropes2.add(5);
        System.out.println("Minimum cost for ropes2: " + solution.solve(ropes2)); // Expected output: 13

        ArrayList<Integer> ropes3 = new ArrayList<>();
        ropes3.add(8);
        ropes3.add(4);
        ropes3.add(6);
        ropes3.add(12);
        ropes3.add(9);
        System.out.println("Minimum cost for ropes3: " + solution.solve(ropes3)); // Expected output: 63

        ArrayList<Integer> ropes4 = new ArrayList<>();
        ropes4.add(10);
        ropes4.add(20);
        ropes4.add(30);
        System.out.println("Minimum cost for ropes4: " + solution.solve(ropes4)); // Expected output: 180
    }
}
