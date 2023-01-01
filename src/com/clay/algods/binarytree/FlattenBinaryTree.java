package algods.binarytree;

public class FlattenBinaryTree {

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

    private static void flattenBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenBinaryTree(root.left);
        flattenBinaryTree(root.right);

        TreeNode leftNode = root.left;
        root.left = null;

        if (leftNode != null){
            TreeNode temp = leftNode;

            while (temp.right != null){
                temp = temp.right;
            }
            temp.right = root.right;
            root.right = leftNode;
        }

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        //root.rightChild.leftChild = new TreeNode(15);
        root.right.right = new TreeNode(6);

        traverse(root);
        System.out.println();
        flattenBinaryTree(root);
        System.out.println();
        traverse(root);
        System.out.println();
    }
}
