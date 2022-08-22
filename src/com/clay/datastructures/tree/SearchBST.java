package tree;

//Give an algorithm for searching an element in binary tree.
public class SearchBST {

    public static void main(String[] args) {
        Tree node = new Tree(1);
        node.left = new Tree(2);
        node.right = new Tree(3);
        node.left.left = new Tree(4);
        node.left.right = new Tree(5);
        node.right.left = new Tree(6);
        node.right.right = new Tree(7);
        Tree.print(node);
        System.out.println("\n" + searchVal(node, 5));
    }


    private static boolean searchVal(Tree tree, int val) {
        if (tree == null) {
            return false;
        }
        if (tree.data == val) {
            return true;
        }
        if (val < tree.data) {
            return searchVal(tree.left, val);
        } else {
            return searchVal(tree.right, val);
        }
    }
/*
    private static boolean searchVal(Tree treeNode, int val) {
        boolean isPresent = false;

        while (treeNode != null) {
            if (treeNode.data == val) {
                isPresent = true;
                break;

            } else if (treeNode.data > val) {
                treeNode = treeNode.left;
            } else {
                treeNode = treeNode.right;
            }
        }
        return isPresent;
    }*/
}
