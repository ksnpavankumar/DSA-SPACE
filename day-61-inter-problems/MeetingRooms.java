public class MeetingRooms {
    /**
     * Finds the maximum number of meeting rooms required at any time.
     * 
     * @param A the number of intervals (meetings)
     * @param B the intervals represented as a 2D array where B[i][0] is the start time
     *          and B[i][1] is the end time of a meeting.
     * @return the maximum number of meeting rooms needed.
     */
    public int findMaxMeetingRooms(int A, int[][] B) {
        // Step 1: Find the maximum endpoint among all intervals
        int maxVal = 0;
        for (int i = 0; i < B.length; i++) {
            maxVal = Math.max(maxVal, B[i][1]);
        }

        // Step 2: Create an array to mark room usage changes
        int[] rooms = new int[maxVal + 1];

        // Step 3: Mark the start and end of each meeting in the rooms array
        for (int i = 0; i < B.length; i++) {
            int start = B[i][0];
            int end = B[i][1];
            rooms[start] += 1; // Increment for meeting start
            rooms[end] -= 1;   // Decrement for meeting end
        }

        // Step 4: Calculate the prefix sum to find the number of ongoing meetings at each time
        int maxRooms = 1; // At least one room is needed
        for (int i = 1; i < rooms.length; i++) {
            rooms[i] = rooms[i] + rooms[i - 1];
            maxRooms = Math.max(maxRooms, rooms[i]); // Track the maximum overlap
        }

        return maxRooms; // Return the peak room usage
    }

    // Main method for testing
    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();

        // Test case 1
        int[][] meetings1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(solution.findMaxMeetingRooms(3, meetings1)); // Expected output: 2

        // Test case 2
        int[][] meetings2 = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(solution.findMaxMeetingRooms(3, meetings2)); // Expected output: 1

        // Test case 3
        int[][] meetings3 = {{1, 4}, {2, 5}, {3, 6}};
        System.out.println(solution.findMaxMeetingRooms(3, meetings3)); // Expected output: 3

        // Test case 4
        int[][] meetings4 = {{1, 10}, {2, 6}, {5, 8}, {9, 12}};
        System.out.println(solution.findMaxMeetingRooms(4, meetings4)); // Expected output: 3
    }

    /*
     * Intuition:
     * The problem asks us to find the maximum number of overlapping meetings at any time.
     * 
     * 1. We break the problem into time points: we mark +1 at the start of a meeting
     *    and -1 at the end of a meeting in a `rooms` array.
     * 
     * 2. By calculating the prefix sum of the `rooms` array, we can track the number of
     *    active meetings at each time point.
     * 
     * 3. The maximum value in this prefix sum indicates the peak number of meeting rooms
     *    required at any time.
     * 
     * This approach avoids sorting and directly uses an array to track meeting activity,
     * making it efficient and easy to implement.
     */
}
