package tree;

import algods.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(printLevelOrder(root));

    }

    private static boolean printLevelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        boolean hasNegativeValue = false;

        while (!q.isEmpty()) {
            TreeNode node = q.remove();

            if (node.val == -1) {
                hasNegativeValue = true;
            }

            System.out.print(node.val + " ");

            if (node.left != null) {
                q.add(node.left);
            } else {
                if (hasNegativeValue) {
                    return false;
                }
                q.add(new TreeNode(-1));
            }

            if (node.right != null) {
                q.add(node.right);
            } else {
                if (hasNegativeValue) {
                    return false;
                }
                q.add(new TreeNode(-1));
            }
        }
        return true;
    }
}
