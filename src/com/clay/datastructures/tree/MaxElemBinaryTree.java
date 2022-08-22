package tree;

//Program to find maximum element in a binary tree
public class MaxElemBinaryTree {

    public static void main(String[] args) {

        // Create a new tree
        Tree root = new Tree(1);

        root.left = new Tree(2);
        root.right = new Tree(3);

        root.left.left = new Tree(4);
        root.left.right = new Tree(5);

        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        // Print the maximum element in the tree
        System.out.println("Maximum element in the tree is: " + maxElement(root));
    }

    /*private static int maxElement(Tree root) {

        int rootVal, left, right, max = Integer.MIN_VALUE;

        if (root != null) {
            rootVal = root.data;
            left = maxElement(root.left);
            right = maxElement(root.right);
        }

        return max;
    }*/
    private static Integer maxElement(Tree root) {

        // If the root is null, return null
        if (root == null) {
            return null;
        }

        // If the root is not null, find the maximum element in the left subtree
        Integer maxLeft = maxElement(root.left);

        // Find the maximum element in the right subtree
        Integer maxRight = maxElement(root.right);

        // If the maximum element in the left subtree is greater than the maximum element in the right subtree,
        // return the maximum element in the left subtree
        if (maxLeft != null && maxLeft > maxRight) {
            return maxLeft;
        }

        // If the maximum element in the left subtree is less than the maximum element in the right subtree,
        // return the maximum element in the right subtree
        if (maxRight != null && maxRight > maxLeft) {
            return maxRight;
        }

        // If the maximum element in the left subtree is equal to the maximum element in the right subtree,
        // return the root element
        return root.data;
    }
}
