package websites.leetcode.interviews.tree;

import algods.binarytree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.rightChild = new TreeNode(2, new TreeNode(3), null);
        List<Integer> result = inorderTraversal(root);

        for (Integer val : result) {
            System.out.print(val + " ");
        }
    }

    static public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        traverse(root, output);
        return output;
    }

    private static void traverse(TreeNode root, List<Integer> output) {
        if (root == null) {
            return;
        }
        traverse(root.leftChild, output);
        output.add(root.data);
        traverse(root.rightChild, output);
    }
}
