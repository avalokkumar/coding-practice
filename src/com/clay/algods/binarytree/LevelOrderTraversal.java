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

        traverse(head.leftChild);
        if (head != null) {
            System.out.print(head.data + " ");
        }
        traverse(head.rightChild);

    }

    private static List<List<Integer>> getLevelOrder(TreeNode root) {

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        int level = 0;
        List<List<Integer>> lists = new ArrayList<>();

        if (root == null) {
            return lists;
        }
        List<Integer> rootValue = new ArrayList<>();
        rootValue.add(root.data);
        lists.add(rootValue);

        nodeQueue.add(root);
        level++;

        while (!nodeQueue.isEmpty()) {

            TreeNode treeNode = nodeQueue.remove();
            level--;

            if (treeNode.leftChild != null) {
                nodeQueue.add(treeNode.leftChild);
            }
            if (treeNode.rightChild != null) {
                nodeQueue.add(treeNode.rightChild);
            }


            if (level == 0 && !nodeQueue.isEmpty()) {
                List<Integer> list = new ArrayList<>();

                for (TreeNode node : nodeQueue) {
                    list.add(node.data);
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
            System.out.print(node.data + " ");
            if (node.leftChild != null) {
                nodeQueue.add(node.leftChild);
            }
            if (node.rightChild != null) {
                nodeQueue.add(node.rightChild);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.leftChild = new TreeNode(9);
        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);
        root.rightChild = new TreeNode(20);
        root.rightChild.leftChild = new TreeNode(15);
        root.rightChild.rightChild = new TreeNode(7);

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
