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

        traverse(head.left);
        if (head != null) {
            System.out.print(head.val + " ");
        }
        traverse(head.right);
    }

    private static void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root);

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);

    }

    private static void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        traverse(root);
        System.out.println();
        invertBinaryTree(root);
        System.out.println();
        traverse(root);
        System.out.println();
    }

}
