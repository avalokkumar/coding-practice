package algods.binarytree;

public class SymmetricTree {

    private static boolean isSymmetric(TreeNode root) {

        if (root == null){
            return true;
        }

        invertBinaryTree(root.leftChild);

        return checkEquals(root.leftChild, root.rightChild);
    }

    private static boolean checkEquals(TreeNode first, TreeNode second) {
        if (first == null || second == null) {
            return first == second;
        }

        return first.data == second.data
                && checkEquals(first.leftChild, second.leftChild)
                && checkEquals(first.rightChild, first.rightChild);
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
        TreeNode root = new TreeNode(2);

        root.leftChild = new TreeNode(3);
        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);

        root.rightChild = new TreeNode(3);
        root.rightChild.leftChild = new TreeNode(5);
        root.rightChild.rightChild = new TreeNode(3);
        System.out.println();
        boolean isSymmetricTree = isSymmetric(root);
        System.out.println(isSymmetricTree);
    }
}
