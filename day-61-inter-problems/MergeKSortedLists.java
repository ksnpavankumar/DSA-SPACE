import java.util.*;

public class MergeKSortedLists {

    // Definition for singly-linked list.
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    // Method to merge K sorted linked lists
    public ListNode mergeKLists(ArrayList<ListNode> a) {
      // below lambda is helpful for sorting 
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);

        // Add the head of each linked list to the heap
        for (ListNode node : a) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // Create a dummy node and initialize tail
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Merge the lists
        while (!minHeap.isEmpty()) {
            ListNode minVal = minHeap.poll();
            tail.next = minVal; // Link the smallest node to the merged list
            tail = minVal;      // Move the tail pointer
            if (minVal.next != null) {
                minHeap.offer(minVal.next); // Add the next node from the same list
            }
        }

        return dummy.next; // Return the merged list (skip dummy node)
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example test cases

        // Create lists: 
        // List 1: 1 -> 4 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        // List 2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // List 3: 2 -> 6
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        // Add the lists to an ArrayList
        ArrayList<ListNode> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        // Call the solution
        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode mergedHead = solution.mergeKLists(lists);

        // Print the merged list
        printList(mergedHead); // Expected output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6

        // Test case with an empty list
        ArrayList<ListNode> emptyLists = new ArrayList<>();
        mergedHead = solution.mergeKLists(emptyLists);
        printList(mergedHead); // Expected output: Empty list

        // Test case with single list
        ArrayList<ListNode> singleList = new ArrayList<>();
        singleList.add(list1);
        mergedHead = solution.mergeKLists(singleList);
        printList(mergedHead); // Expected output: 1 -> 4 -> 5

        // Test case with all null lists
        ArrayList<ListNode> nullLists = new ArrayList<>();
        nullLists.add(null);
        nullLists.add(null);
        nullLists.add(null);
        mergedHead = solution.mergeKLists(nullLists);
        printList(mergedHead); // Expected output: Empty list
    }
}
