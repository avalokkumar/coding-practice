package datastructures.tree;

import algods.binarytree.TreeNode;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        invertTree(root);

        TreeNode.print(root);

    }

    /**
     *                 3
     *       9                     20
     *   4      5           15          7
     *
     *
     * output
     *                       3
     *             20                     9
     *         7      15           5          4
     * @param root
     */
    public static void invertTree(TreeNode root) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
    }

    private static void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
