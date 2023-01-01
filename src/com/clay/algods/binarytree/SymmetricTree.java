package algods.binarytree;

public class SymmetricTree {

    private static boolean isSymmetric(TreeNode root) {

        if (root == null){
            return true;
        }

        invertBinaryTree(root.left);

        return checkEquals(root.left, root.right);
    }

    private static boolean checkEquals(TreeNode first, TreeNode second) {
        if (first == null || second == null) {
            return first == second;
        }

        return first.val == second.val
                && checkEquals(first.left, second.left)
                && checkEquals(first.right, first.right);
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
        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(3);
        System.out.println();
        boolean isSymmetricTree = isSymmetric(root);
        System.out.println(isSymmetricTree);
    }
}
