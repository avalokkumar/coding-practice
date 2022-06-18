package algods.binarytree;


public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(2);
        root.leftChild.leftChild = new TreeNode(3);
        root.rightChild.rightChild = new TreeNode(3);
        root.leftChild.leftChild.leftChild = new TreeNode(4);
        root.rightChild.rightChild.rightChild = new TreeNode(4);

        /*root.leftChild = new TreeNode(9);
        root.rightChild = new TreeNode(20);
        root.rightChild.leftChild = new TreeNode(15);
        root.rightChild.rightChild = new TreeNode(7);*/

       /* root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(2);
        root.leftChild.leftChild = new TreeNode(3);
        root.leftChild.rightChild = new TreeNode(3);
        root.leftChild.leftChild.leftChild = new TreeNode(4);
        root.leftChild.leftChild.rightChild = new TreeNode(4);*/

        //System.out.println(isBinarySearchTree(root));
//        System.out.println(isBalanced(root));
    }

    //program to traverse the tree in inorder fashion and check if the tree is balanced

    // program to get height of a tree


    //program to print child nodes of the tree in inorder fashion
    public static void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.leftChild);
        System.out.print(root.data + " ");
        printInorder(root.rightChild);
    }


    private static int getHeightDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeightDiff(root.leftChild), getHeightDiff(root.rightChild)) + 1;
    }
}
