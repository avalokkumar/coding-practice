package websites.geeksforgeeks.tree;

public class AVLTree {
    private TreeNode insert(TreeNode TreeNode, int data) {
        if (TreeNode == null) {
            return new TreeNode(data);
        }

        if (data < TreeNode.data) {
            TreeNode.left = insert(TreeNode.left, data);
        } else {
            TreeNode.right = insert(TreeNode.right, data);
        }

        TreeNode.height = Math.max(height(TreeNode.left), height(TreeNode.right)) + 1;
        int balance = getBalance(TreeNode);

        if (balance > 1 && data < TreeNode.left.data) {
            return rightRotate(TreeNode);
        }

        if (balance < -1 && data > TreeNode.right.data) {
            return leftRotate(TreeNode);
        }

        if (balance > 1 && data > TreeNode.left.data) {
            TreeNode.left = leftRotate(TreeNode.left);
            return rightRotate(TreeNode);
        }

        if (balance < -1 && data < TreeNode.right.data) {
            TreeNode.right = rightRotate(TreeNode.right);
            return leftRotate(TreeNode);
        }

        return TreeNode;
    }

    private TreeNode rightRotate(TreeNode treeNode) {
        TreeNode left = treeNode.left;
        TreeNode leftRight = left.right;

        left.right = treeNode;
        treeNode.left = leftRight;

        treeNode.height = Math.max(height(treeNode.left), height(treeNode.right)) + 1;
        left.height = Math.max(height(left.left), height(left.right)) + 1;

        return left;
    }

    private TreeNode leftRotate(TreeNode TreeNode) {
        TreeNode right = TreeNode.right;
        TreeNode rightLeft = right.left;

        right.left = TreeNode;
        TreeNode.right = rightLeft;

        TreeNode.height = Math.max(height(TreeNode.left), height(TreeNode.right)) + 1;
        right.height = Math.max(height(right.left), height(right.right)) + 1;

        return right;
    }

    private int height(TreeNode left) {
        if (left == null) {
            return 0;
        }

        return left.height;
    }

    private int getBalance(TreeNode TreeNode) {
        if (TreeNode == null) {
            return 0;
        }

        return height(TreeNode.left) - height(TreeNode.right);
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        TreeNode root = null;
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180};
        for (int i = 0; i < arr.length; i++) {
            root = tree.insert(root, arr[i]);
        }
        //print AVL nodes
        System.out.println("AVL Tree");
        tree.print(root);
    }

    private void print(TreeNode root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.println(root.data);
        print(root.right);
    }
}
