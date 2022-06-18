package algods.binarytree;

public class IsBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);

        root.leftChild = new TreeNode(4);
        root.leftChild.leftChild = new TreeNode(3);
        root.leftChild.rightChild = new TreeNode(5);
        root.rightChild = new TreeNode(19);
        root.rightChild.leftChild = new TreeNode(16);
        root.rightChild.rightChild = new TreeNode(37);

        //System.out.println(isBinarySearchTree(root));
        System.out.println(isBinarySearchTreeOptimized(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static boolean isBinarySearchTreeOptimized(TreeNode root, int min, int max) {
        if (root == null){
            return true;
        }

        if ( root.data > min && root.data < max
                &&isBinarySearchTreeOptimized(root.leftChild, min, root.data)
                && isBinarySearchTreeOptimized(root.rightChild, root.data, max)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isBinarySearchTree(TreeNode root) {
        if (root == null){
            return true;
        }

        if (isLeftSubtreeLesser(root.leftChild, root.data)
                && isRightSubtreeGreater(root.rightChild, root.data)
                && isBinarySearchTree(root.leftChild)
                && isBinarySearchTree(root.rightChild)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isRightSubtreeGreater(TreeNode root, int data) {
        if (root == null){
            return true;
        }
        return (root.data > data
                && isRightSubtreeGreater(root.leftChild, data)
                && isRightSubtreeGreater(root.rightChild, data));
    }
    private static boolean isLeftSubtreeLesser(TreeNode root, int data) {
        if (root == null){
            return true;
        }
        return (root.data <= data
                && isLeftSubtreeLesser(root.leftChild, data)
                && isLeftSubtreeLesser(root.rightChild, data));
    }


}
