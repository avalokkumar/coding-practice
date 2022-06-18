package algods.binarytree;

/**
 *              3
 *
 *      9            20
 *
 *    4   5       15    7
 */

public class SumOfLeftLeaves {

    private static int getSumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int ls = getSumOfLeftLeaves(root.leftChild);
        int rs = getSumOfLeftLeaves(root.rightChild);

        if (root.leftChild != null
                && root.leftChild.leftChild == null
                && root.leftChild.rightChild == null){

            ls += root.leftChild.data;
        }

        return ls + rs;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.leftChild = new TreeNode(9);
        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);

        root.rightChild = new TreeNode(20);
        root.rightChild.leftChild = new TreeNode(15);
        root.rightChild.rightChild = new TreeNode(7);

        int sumOfLeftLeaves = getSumOfLeftLeaves(root);

        System.out.println(sumOfLeftLeaves);
    }


}
