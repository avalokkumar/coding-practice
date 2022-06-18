package algods.binarytree;

public class MinimumDepthofBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        //root.leftChild = new TreeNode(2);
        root.leftChild = new TreeNode(9);
        root.rightChild = new TreeNode(20);
        root.rightChild.leftChild = new TreeNode(15);
        root.rightChild.rightChild = new TreeNode(7);

        //System.out.println(isBinarySearchTree(root));
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.leftChild);
        int rightDepth = minDepth(root.rightChild);

        if (leftDepth == 0 || rightDepth == 0){
            return Math.max(leftDepth, rightDepth) + 1;
        }else {
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }
}
