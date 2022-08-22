package algods.binarytree;

public class TreeNode {

    public TreeNode leftChild;
    public TreeNode rightChild;
    public int data;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.leftChild = left;
        this.rightChild = right;
    }

}
