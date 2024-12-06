static class ListNode {
    int val;  // The value of the node
    ListNode next;  // Pointer to the next node in the list

    // Constructor to initialize a new node
    public ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}

// Head of the linked list
static ListNode head = null;
// Size of the linked list
static int size_of_ll = 0;

/**
 * Inserts a node with the given value at the specified position.
 * Position starts at 1.
 */
public static void insertNode(int position, int value) {
    if (position >= 1 && position <= size_of_ll + 1) {
        ListNode temp = new ListNode(value);

        if (position == 1) {  // Inserting at the head
            temp.next = head;  // Link the new node to the current head
            head = temp;  // Update the head to the new node
        } else {  // Inserting at a position other than the head
            ListNode prev = head;
            int i = 1;
            while (i < position - 1) {  // Traverse to the (position-1)th node
                prev = prev.next;
                i++;
            }

            temp.next = prev.next;  // Link the new node to the next node
            prev.next = temp;  // Update the previous node's next pointer to the new node
        }

        size_of_ll++;  // Increment the size of the linked list
    }
}

/**
 * Deletes the node at the specified position.
 * Position starts at 1.
 */
public static void deleteNode(int position) {
    if (position >= 1 && position <= size_of_ll) {
        if (position == 1) {  // Deleting the head node
            head = head.next;  // Update the head to the next node
        } else {  // Deleting a node other than the head
            ListNode prev = head;
            int i = 1;
            while (i < position - 1) {  // Traverse to the (position-1)th node
                prev = prev.next;
                i++;
            }

            prev.next = prev.next.next;  // Update the next pointer to skip the deleted node
        }

        size_of_ll--;  // Decrement the size of the linked list
    }
}

/**
 * Prints the entire linked list.
 * Each element is followed by a single space, with no trailing space.
 */
public static void printLinkedList() {
    ListNode temp = head;
    boolean first = true;

    while (temp != null) {  // Traverse until the end of the list
        if (first) {
            System.out.print(temp.val);  // Print the first element without leading space
            first = false;
        } else {
            System.out.print(" " + temp.val);  // Print subsequent elements with a leading space
        }
        temp = temp.next;
    }
    System.out.println();
}

public static void main(String[] args) {
    // Example usage

    // Insert nodes
    insertNode(1, 10);  // Linked list: 10
    insertNode(2, 20);  // Linked list: 10 -> 20
    insertNode(1, 5);   // Linked list: 5 -> 10 -> 20
    insertNode(3, 15);  // Linked list: 5 -> 10 -> 15 -> 20

    System.out.println("After insertions:");
    printLinkedList();  // Output: 5 10 15 20

    // Delete nodes
    deleteNode(1);  // Remove the head node, Linked list: 10 -> 15 -> 20
    deleteNode(2);  // Remove the second node, Linked list: 10 -> 20

    System.out.println("After deletions:");
    printLinkedList();  // Output: 10 20

    // Additional Examples
    // Insert more nodes
    insertNode(3, 25);  // Linked list: 10 -> 20 -> 25
    insertNode(2, 12);  // Linked list: 10 -> 12 -> 20 -> 25

    System.out.println("After more insertions:");
    printLinkedList();  // Output: 10 12 20 25

    // Delete additional nodes
    deleteNode(4);  // Remove last node, Linked list: 10 -> 12 -> 20
    deleteNode(2);  // Remove second node, Linked list: 10 -> 20

    System.out.println("After more deletions:");
    printLinkedList();  // Output: 10 20
}
