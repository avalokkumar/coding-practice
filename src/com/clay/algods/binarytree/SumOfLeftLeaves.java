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

        int ls = getSumOfLeftLeaves(root.left);
        int rs = getSumOfLeftLeaves(root.right);

        if (root.left != null
                && root.left.left == null
                && root.left.right == null){

            ls += root.left.val;
        }

        return ls + rs;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int sumOfLeftLeaves = getSumOfLeftLeaves(root);

        System.out.println(sumOfLeftLeaves);
    }


}
