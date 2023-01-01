package datastructures.tree;


import algods.binarytree.TreeNode;

import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[15,7],[9,20],[3]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 */
public class ReverseLevelOrderTraversal {

    public static void main(String[] args) {
       Integer[] root = new Integer[]{3,9,20,34,23,15,7};
//       TreeNode.print(TreeNode.insertLevelOrder(root, 0));
        for (List<Integer> val: levelOrderBottom(TreeNode.insertLevelOrder(root, 0))) {
//            System.out.println(val);
        }
    }

/*                    3
        9                       20
    34      23              15      7*/


    // output -[34 23 15 7] [9 20] [3]

    //
    //stack - 3 9 20 34 23 15 7
    //q - 3     [3]
    //q - 9 20
    //q - 20 34 23
    //q - 34 23 15 7

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            result.add(0, new ArrayList<>());
            TreeNode current = queue.poll();
            if (current.right != null) {
                queue.add(current.right);
            }

            if (current.left != null) {
                queue.add(current.left);
            }
            stack.push(current);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val+ " ");
        }

        return result;
    }
}
