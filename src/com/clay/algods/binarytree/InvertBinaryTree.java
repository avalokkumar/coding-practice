package algods.binarytree;

/**
 *              3
 *
 *      9            20
 *
 *    4   5       15    7
 */


/**
 * Inverse tree
 *
 *             3
 *     20              9
 *
 *  7       15       5     4
 *
 */
public class InvertBinaryTree {

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

    private static void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root);

        invertBinaryTree(root.leftChild);
        invertBinaryTree(root.rightChild);

    }

    private static void swap(TreeNode root) {
        TreeNode temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.leftChild = new TreeNode(9);
        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);

        root.rightChild = new TreeNode(20);
        root.rightChild.leftChild = new TreeNode(15);
        root.rightChild.rightChild = new TreeNode(7);

        traverse(root);
        System.out.println();
        invertBinaryTree(root);
        System.out.println();
        traverse(root);
        System.out.println();
    }

}
