// Time & space complexity O(N) O(N)

public class MeetingRooms {
    public int solve(int A, int[][] B) { // Function to find the maximum number of overlapping intervals
        int maxVal = 0;
        for (int i = 0; i < B.length; i++) {
            maxVal = Math.max(maxVal, B[i][1]); // Update maxVal with the highest end value in intervals
        }

        int[] rooms = new int[maxVal + 1];

        for (int i = 0; i < B.length; i++) {
            int s = B[i][0];
            int e = B[i][1];
            rooms[s] += 1; // Increment at start index to mark a room being occupied
            rooms[e] -= 1; // Decrement at end index to mark a room being freed
        }

        int maxRooms = 1;
        for (int i = 1; i < rooms.length; i++) {
            rooms[i] = rooms[i] + rooms[i - 1]; // Cumulative sum to track ongoing room occupancy // prefix sum logic
            maxRooms = Math.max(maxRooms, rooms[i]); // Update maxRooms if current occupancy exceeds previous max
        }
        return maxRooms;
    }

    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();

        // Test case 1: Regular intervals with overlaps
        int[][] intervals1 = { { 1, 4 }, { 2, 5 }, { 7, 9 } };
        System.out.println("Max rooms needed (Test Case 1): " + solution.solve(3, intervals1)); // Expected: 2
        // Explanation: Intervals [1,4] and [2,5] overlap, so max rooms = 2

        // Test case 2: No overlap between intervals
        int[][] intervals2 = { { 1, 3 }, { 4, 6 }, { 7, 9 } };
        System.out.println("Max rooms needed (Test Case 2): " + solution.solve(3, intervals2)); // Expected: 1
        // Explanation: No intervals overlap, so only 1 room is needed

        // Test case 3: Fully overlapping intervals
        int[][] intervals3 = { { 1, 5 }, { 1, 5 }, { 1, 5 } };
        System.out.println("Max rooms needed (Test Case 3): " + solution.solve(3, intervals3)); // Expected: 3
        // Explanation: All intervals overlap completely, so max rooms = 3

        // Test case 4: Nested intervals (one interval inside another)
        int[][] intervals4 = { { 1, 10 }, { 2, 5 }, { 6, 9 } };
        System.out.println("Max rooms needed (Test Case 4): " + solution.solve(3, intervals4)); // Expected: 2
        // Explanation: [1,10] overlaps with [2,5] and [6,9], so max overlap = 2 rooms

        // Test case 5: Edge case with single interval
        int[][] intervals5 = { { 1, 2 } };
        System.out.println("Max rooms needed (Test Case 5): " + solution.solve(1, intervals5)); // Expected: 1
        // Explanation: Only one interval, so only 1 room is needed

        // Test case 6: Intervals touching boundaries (e.g., [1,2], [2,3])
        int[][] intervals6 = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
        System.out.println("Max rooms needed (Test Case 6): " + solution.solve(3, intervals6)); // Expected: 1
        // Explanation: Intervals just touch but don't overlap, so only 1 room needed

        // Test case 7: Large number of intervals for performance testing
        int[][] intervals7 = new int[1000][2];
        for (int i = 0; i < 1000; i++) {
            intervals7[i][0] = i;
            intervals7[i][1] = i + 2;
        }
        System.out.println("Max rooms needed (Test Case 7): " + solution.solve(1000, intervals7)); // Expected: Depends
                                                                                                   // on overlaps
        // Explanation: Many intervals with small overlaps to test efficiency on large
        // input

        // Test case 8: Intervals with same start time
        int[][] intervals8 = { { 1, 4 }, { 1, 5 }, { 1, 3 } };
        System.out.println("Max rooms needed (Test Case 8): " + solution.solve(3, intervals8)); // Expected: 3
        // Explanation: All intervals start at the same time, so max rooms = 3

        // Test case 9: Edge case with zero intervals
        int[][] intervals9 = {};
        System.out.println("Max rooms needed (Test Case 9): " + solution.solve(0, intervals9)); // Expected: 0
        // Explanation: No intervals provided, so no rooms needed
    }
}
