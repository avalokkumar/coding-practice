package algods.binarytree;

public class FlattenBinaryTree {

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

    private static void flattenBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenBinaryTree(root.leftChild);
        flattenBinaryTree(root.rightChild);

        TreeNode leftNode = root.leftChild;
        root.leftChild = null;

        if (leftNode != null){
            TreeNode temp = leftNode;

            while (temp.rightChild != null){
                temp = temp.rightChild;
            }
            temp.rightChild = root.rightChild;
            root.rightChild = leftNode;
        }

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.leftChild = new TreeNode(2);
        root.leftChild.leftChild = new TreeNode(3);
        root.leftChild.rightChild = new TreeNode(4);

        root.rightChild = new TreeNode(5);
        //root.rightChild.leftChild = new TreeNode(15);
        root.rightChild.rightChild = new TreeNode(6);

        traverse(root);
        System.out.println();
        flattenBinaryTree(root);
        System.out.println();
        traverse(root);
        System.out.println();
    }
}
