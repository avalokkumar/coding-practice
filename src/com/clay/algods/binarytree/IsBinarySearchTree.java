package algods.binarytree;

public class IsBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(19);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(37);

        //System.out.println(isBinarySearchTree(root));
        System.out.println(isBinarySearchTreeOptimized(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static boolean isBinarySearchTreeOptimized(TreeNode root, int min, int max) {
        if (root == null){
            return true;
        }

        if ( root.val > min && root.val < max
                &&isBinarySearchTreeOptimized(root.left, min, root.val)
                && isBinarySearchTreeOptimized(root.right, root.val, max)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isBinarySearchTree(TreeNode root) {
        if (root == null){
            return true;
        }

        if (isLeftSubtreeLesser(root.left, root.val)
                && isRightSubtreeGreater(root.right, root.val)
                && isBinarySearchTree(root.left)
                && isBinarySearchTree(root.right)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isRightSubtreeGreater(TreeNode root, int data) {
        if (root == null){
            return true;
        }
        return (root.val > data
                && isRightSubtreeGreater(root.left, data)
                && isRightSubtreeGreater(root.right, data));
    }
    private static boolean isLeftSubtreeLesser(TreeNode root, int data) {
        if (root == null){
            return true;
        }
        return (root.val <= data
                && isLeftSubtreeLesser(root.left, data)
                && isLeftSubtreeLesser(root.right, data));
    }


}
