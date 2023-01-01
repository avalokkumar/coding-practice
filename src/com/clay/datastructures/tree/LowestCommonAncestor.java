package datastructures.tree;

import algods.binarytree.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 *                      6
 *          2                       8
 *    0             4        7              9
 *              3       5
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(21);

        root1.left = new TreeNode(2);
        root1.right = new TreeNode(8);

        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(4);
        root1.left.right.left = new TreeNode(3);
        root1.left.right.right = new TreeNode(5);

        root1.right.left = new TreeNode(7);
        root1.right.right = new TreeNode(9);

        TreeNode result = lowestCommonAncestor(root1, new TreeNode(2), new TreeNode(8));

        System.out.println(result.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while (current != null) {
            if (p.val < current.val && q.val < current.val) {
                current = current.left;

            } else if (p.val > current.val && q.val > current.val) {
                current = current.right;

            } else {
                return current;
            }
        }
        return null;
    }
}
