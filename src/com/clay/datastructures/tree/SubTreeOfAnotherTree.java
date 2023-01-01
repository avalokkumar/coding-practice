package datastructures.tree;

import algods.binarytree.TreeNode;

/**
 *
 */
public class SubTreeOfAnotherTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        root.right = new TreeNode(5);

        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));

        System.out.println(isSubtree(root, subRoot));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    private static boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        return isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right)
                && root1.val == root2.val;
    }
}
