package datastructures.tree;

import algods.binarytree.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder
 * traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
public class BuildTree {

    public static void main(String[] args) {

        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode result = buildTree(preorder, inorder);
        List<List<Integer>> lists = LevelOrderTraversal2.levelOrder(result);
        for (List<Integer> val: lists) {
            System.out.print(val + " ");
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int m = 0;

        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                m = i;
            }
        }

        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, m + 1),
                Arrays.copyOfRange(inorder, 0, m)
        );

        root.right = buildTree(
                Arrays.copyOfRange(preorder, m + 1, preorder.length),
                Arrays.copyOfRange(inorder, m + 1, inorder.length)
        );

        return root;
    }

}
