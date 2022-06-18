package algods.binarytree;

import java.util.Arrays;
import java.util.List;

public class SortedListtoBinarySearchTree {

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

    public static void main(String[] args) {
        //System.out.println(isBinarySearchTree(root));
        TreeNode binarySearchTree = getBinarySearchTree(Arrays.asList(-10,-3,0,5,9));
    }

    public static TreeNode getBinarySearchTree(List<Integer> sortedValues) {

        int mid = sortedValues.size()/2;

        return null;
    }
}
