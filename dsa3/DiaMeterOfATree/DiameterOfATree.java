// Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class DiameterOfATree {
    int diameter = 0;

    public int solve(TreeNode A) {
        calculateDiameter(A);
        return diameter;
    }

    public int calculateDiameter(TreeNode A) {
        if (A == null) {
            return -1;
        }
        int lh = calculateDiameter(A.left); // Calculate the left height
        int rh = calculateDiameter(A.right); // Calculate the right height
        diameter = Math.max(diameter, (lh + rh + 2)); // Update diameter
        return Math.max(lh, rh) + 1; // Return height
    }

    public static void main(String[] args) {
        // Create first binary tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        // Create second binary tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);

        // Create third binary tree
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.right = new TreeNode(3);
        root3.right.right.right = new TreeNode(4);

        // Create the DiameterOfATree instance
        DiameterOfATree diameterOfATree = new DiameterOfATree();

        // Calculate the diameter for the first tree
        int diameter1 = diameterOfATree.solve(root1);
        System.out.println("Diameter of the first binary tree: " + diameter1);

        // Calculate the diameter for the second tree
        int diameter2 = diameterOfATree.solve(root2);
        System.out.println("Diameter of the second binary tree: " + diameter2);

        // Calculate the diameter for the third tree
        int diameter3 = diameterOfATree.solve(root3);
        System.out.println("Diameter of the third binary tree: " + diameter3);
    }
}
