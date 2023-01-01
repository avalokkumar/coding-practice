package datastructures.tree;

import algods.binarytree.TreeNode;

import java.util.Stack;

public class TreeTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("inorderNonRec");
        inorderNonRec(root);
        System.out.println("\ninorderRec");
        inorderRec(root);


        System.out.println("\n\npreorderNonRec");
        preorderNonRec(root);
        System.out.println("\npreorderRec");
        preorderRec(root);

        System.out.println("\n\npostorderNonRec");
        postorderNonRec(root);
        System.out.println("\npostorderRec");
        postorderRec(root);
    }

    private static void postorderRec(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderRec(root.left);
        postorderRec(root.right);
        System.out.print(root.val + " ");
    }

    private static void postorderNonRec(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        if (root == null) {
            return;
        }

        st.push(root);

        while (!st.isEmpty()) {

            TreeNode treeNode = st.pop();
            st2.push(treeNode);

            if (treeNode.left != null) {
                st.push(treeNode.left);
            }

            if (treeNode.right != null) {
                st.push(treeNode.right);
            }
        }

        while (!st2.isEmpty()) {
            System.out.print(st2.pop().val + " ");
        }
    }

    private static void preorderRec(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderRec(root.left);
        preorderRec(root.right);
    }

    private static void preorderNonRec(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if (root == null) {
            return;
        }

        st.push(root);

        while (!st.isEmpty()) {

            TreeNode treeNode = st.pop();
            System.out.print(treeNode.val + " ");

            if (treeNode.right != null) {
                st.push(treeNode.right);
            }

            if (treeNode.left != null) {
                st.push(treeNode.left);
            }
        }
    }

    private static void inorderRec(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderRec(root.left);
        System.out.print(root.val + " ");
        inorderRec(root.right);
    }

    private static void inorderNonRec(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if (root == null) {
            return;
        }

        TreeNode curr = root;

        while (curr != null || !st.isEmpty()) {

            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }
}
