# Tree Traversals: Preorder, Inorder, and Postorder

## Introduction
Tree traversal is a method of visiting all nodes in a tree data structure. The three main types of **Depth First Traversal (DFS)** are:

1. **Preorder Traversal (Root → Left → Right)**
2. **Inorder Traversal (Left → Root → Right)**
3. **Postorder Traversal (Left → Right → Root)**

---

## 1. Preorder Traversal
### **Algorithm:**
1. Visit the **root** node.
2. Recursively traverse the **left** subtree.
3. Recursively traverse the **right** subtree.

### **Example:**
```
       1
      / \
     2   3
    / \
   4   5
```
#### **Preorder Output:**
```
1 2 4 5 3
```

---

## 2. Inorder Traversal
### **Algorithm:**
1. Recursively traverse the **left** subtree.
2. Visit the **root** node.
3. Recursively traverse the **right** subtree.

### **Example:**
```
       1
      / \
     2   3
    / \
   4   5
```
#### **Inorder Output:**
```
4 2 5 1 3
```

---

## 3. Postorder Traversal
### **Algorithm:**
1. Recursively traverse the **left** subtree.
2. Recursively traverse the **right** subtree.
3. Visit the **root** node.

### **Example:**
```
       1
      / \
     2   3
    / \
   4   5
```
#### **Postorder Output:**
```
4 5 2 3 1
```

---

## Java Implementation
```java
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int value) {
        val = value;
        left = right = null;
    }
}

class BinaryTree {
    TreeNode root;

    // Preorder Traversal
    void preorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");  // Visit root
        preorder(node.left);               // Left subtree
        preorder(node.right);              // Right subtree
    }

    // Inorder Traversal
    void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);                // Left subtree
        System.out.print(node.val + " ");  // Visit root
        inorder(node.right);               // Right subtree
    }

    // Postorder Traversal
    void postorder(TreeNode node) {
        if (node == null) return;
        postorder(node.left);              // Left subtree
        postorder(node.right);             // Right subtree
        System.out.print(node.val + " ");  // Visit root
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Preorder:");
        tree.preorder(tree.root);

        System.out.println("\nInorder:");
        tree.inorder(tree.root);

        System.out.println("\nPostorder:");
        tree.postorder(tree.root);
    }
}
```

### **Expected Output:**
```
Preorder:
1 2 4 5 3

Inorder:
4 2 5 1 3

Postorder:
4 5 2 3 1
```

---

## **Comparison of Traversals**
| Traversal Type | Order | Use Case |
|---------------|----------------|----------------|
| **Preorder (Root → Left → Right)** | `1 2 4 5 3` | Used in **copying** a tree, prefix expressions |
| **Inorder (Left → Root → Right)** | `4 2 5 1 3` | Used for **BST sorting**, infix expressions |
| **Postorder (Left → Right → Root)** | `4 5 2 3 1` | Used for **deleting trees**, postfix expressions |

---

## Conclusion
- **Preorder** is useful for creating a copy of a tree.
- **Inorder** is useful for sorting a **Binary Search Tree (BST)**.
- **Postorder** is useful for deleting trees.

This guide explains tree traversal with clear examples and Java code. 🚀 Happy coding!

