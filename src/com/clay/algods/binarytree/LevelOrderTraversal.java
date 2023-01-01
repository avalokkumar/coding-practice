package algods.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    private static void traverse(TreeNode head) {
        if (head == null) {
            return;
        }

        traverse(head.left);
        if (head != null) {
            System.out.print(head.val + " ");
        }
        traverse(head.right);

    }

    private static List<List<Integer>> getLevelOrder(TreeNode root) {

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        int level = 0;
        List<List<Integer>> lists = new ArrayList<>();

        if (root == null) {
            return lists;
        }
        List<Integer> rootValue = new ArrayList<>();
        rootValue.add(root.val);
        lists.add(rootValue);

        nodeQueue.add(root);
        level++;

        while (!nodeQueue.isEmpty()) {

            TreeNode treeNode = nodeQueue.remove();
            level--;

            if (treeNode.left != null) {
                nodeQueue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nodeQueue.add(treeNode.right);
            }


            if (level == 0 && !nodeQueue.isEmpty()) {
                List<Integer> list = new ArrayList<>();

                for (TreeNode node : nodeQueue) {
                    list.add(node.val);
                    level++;
                }
                lists.add(list);
            }
        }

        return lists;
    }

    private static void printLevelOrder(TreeNode root) {

        Queue<TreeNode> nodeQueue = new LinkedList<>();

        if (root == null) {
            return;
        }
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            System.out.print(node.val + " ");
            if (node.left != null) {
                nodeQueue.add(node.left);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        printLevelOrder(root);
        //List<List<Integer>> levelOrder = getLevelOrder(root);
        System.out.println();
        /*for (List<Integer> level : levelOrder) {
            System.out.println();
            for (Integer value : level) {
                System.out.print(value + " ");
            }
            System.out.println();
        }*/
    }

}
