class ListNode:
    def __init__(self, x):
        self.val = x  # The value of the node
        self.next = None  # Pointer to the next node in the list

head = None  # Head of the linked list
size_of_ll = 0  # Size of the linked list

def insert_node(position, value):
    """
    Inserts a node with the given value at the specified position.
    Position starts at 1.
    """
    global head
    global size_of_ll

    if position >= 1 and position <= size_of_ll + 1:
        temp = ListNode(value)

        if position == 1:  # Inserting at the head
            temp.next = head  # Link the new node to the current head
            head = temp  # Update the head to the new node
        else:  # Inserting at a position other than the head
            prev = head
            i = 1
            while i < position - 1:  # Traverse to the (position-1)th node
                prev = prev.next
                i += 1

            temp.next = prev.next  # Link the new node to the next node
            prev.next = temp  # Update the previous node's next pointer to the new node

        size_of_ll += 1  # Increment the size of the linked list

def delete_node(position):
    """
    Deletes the node at the specified position.
    Position starts at 1.
    """
    global head
    global size_of_ll

    if position >= 1 and position <= size_of_ll:
        if position == 1:  # Deleting the head node
            head = head.next  # Update the head to the next node
        else:  # Deleting a node other than the head
            prev = head
            i = 1
            while i < position - 1:  # Traverse to the (position-1)th node
                prev = prev.next
                i += 1

            prev.next = prev.next.next  # Update the next pointer to skip the deleted node

        size_of_ll -= 1  # Decrement the size of the linked list

def print_ll():
    """
    Prints the entire linked list.
    Each element is followed by a single space, with no trailing space.
    """
    global head

    node_list = []  # List to store node values
    current = head

    while current is not None:  # Traverse until the end of the list
        node_list.append(str(current.val))  # Convert values to string for joining
        current = current.next

    print(" ".join(node_list))  # Print the values as a space-separated string

# Example usage
# Insert nodes
insert_node(1, 10)  # Linked list: 10
insert_node(2, 20)  # Linked list: 10 -> 20
insert_node(1, 5)   # Linked list: 5 -> 10 -> 20
insert_node(3, 15)  # Linked list: 5 -> 10 -> 15 -> 20

# Print the linked list
print("After insertions:")
print_ll()  # Output: 5 10 15 20

# Delete nodes
delete_node(1)  # Remove the head node, Linked list: 10 -> 15 -> 20
delete_node(2)  # Remove the second node, Linked list: 10 -> 20

# Print the linked list
print("After deletions:")
print_ll()  # Output: 10 20
