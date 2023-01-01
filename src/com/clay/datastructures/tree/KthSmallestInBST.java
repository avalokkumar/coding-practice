package datastructures.tree;


import algods.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  Given the root of a binary search tree, and an integer k,
 *  return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 *  Input: root = [3,1,4,null,2], k = 1
 *  Output: 1
 */
public class KthSmallestInBST {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);

        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(1);
        root1.right = new TreeNode(5);

        root1.left.right = new TreeNode(3);

        System.out.println(kthSmallest2(root1, 3));
    }

    /**
     *                        3
     *
     *               1                    4
     *
     *                    2
     */
    public static int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            k--;
            if (k == 0) {
                return current.val;
            }
            current = current.right;
        }
        return -1;
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        iterateInOrder(root, values);

        return values.get(k-1);
    }
    private static void iterateInOrder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        iterateInOrder(root.left, values);
        values.add(root.val);
        iterateInOrder(root.left, values);
    }
}
