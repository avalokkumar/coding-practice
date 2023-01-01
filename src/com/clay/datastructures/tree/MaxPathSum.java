package datastructures.tree;

import algods.binarytree.TreeNode;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * <p>
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * <p>
 * <p>
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * <p>
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 */
public class MaxPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        getMaxPathSum(root, res);
        return res[0];
    }

    private static int getMaxPathSum(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, getMaxPathSum(root.left, res));
        int right = Math.max(0, getMaxPathSum(root.right, res));

        res[0] = Math.max(res[0], root.val + left + right);

        return root.val + Math.max(left, right);
    }
}
