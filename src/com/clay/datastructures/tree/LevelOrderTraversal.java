package tree;

import algods.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(3);
        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);

        System.out.println(printLevelOrder(root));

    }

    private static boolean printLevelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        boolean hasNegativeValue = false;

        while (!q.isEmpty()) {
            TreeNode node = q.remove();

            if (node.data == -1) {
                hasNegativeValue = true;
            }

            System.out.print(node.data + " ");

            if (node.leftChild != null) {
                q.add(node.leftChild);
            } else {
                if (hasNegativeValue) {
                    return false;
                }
                q.add(new TreeNode(-1));
            }

            if (node.rightChild != null) {
                q.add(node.rightChild);
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
