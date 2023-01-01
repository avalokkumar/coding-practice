package datastructures.tree;

import algods.binarytree.TreeNode;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 */

public class LevelOrderTraversal2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(null);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> levelOrderValues = levelOrder(root);

        for (List<Integer> val : levelOrderValues) {
            System.out.print(val + " ");
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int qLen = queue.size();
            ArrayList<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < qLen; i++) {
                TreeNode currNode = queue.remove();
                if (currNode != null) {
                    levelNodes.add(currNode.val);
                    queue.add(currNode.left);
                    queue.add(currNode.right);
                }
            }

            if (!levelNodes.isEmpty()) {
                res.add(levelNodes);
            }
        }

        return res;
    }
}
