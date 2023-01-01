package datastructures.tree;

import algods.binarytree.TreeNode;

/**
 * 98. Validate Binary Search Tree
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Input: root = [2,1,3]
 * Output: true
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 *
 */
public class ValidateBST {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2147483647);

//        root1.left = new TreeNode(1);
//        root1.right = new TreeNode(3);
//
//        root1.left.left = new TreeNode(0);
//        root1.left.right = new TreeNode(4);
//        root1.left.right.left = new TreeNode(3);
//        root1.left.right.right = new TreeNode(5);

        System.out.println(isValidBST(root1));

    }

    public static boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValid(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }

        if (root.val <= left || root.val >= right) {
            return false;
        }

        return isValid(root.left, left, root.val)
                && isValid(root.right, root.val, right);
    }
}
