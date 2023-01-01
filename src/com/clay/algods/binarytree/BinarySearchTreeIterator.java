package algods.binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BinarySearchTreeIterator implements Iterator<TreeNode> {

    Queue<TreeNode> iterator = new LinkedList<>();

    /**
     * @param order: -1 for preorder, 0 for inorder, 1 for postorder
     */
    BinarySearchTreeIterator(TreeNode root, int order) {

        switch (order) {
            case -1:
                addElementsInPreorder(root);
                break;
            case 0:
                addElementsInOrder(root);
                break;
            case 1:
                addElementsInPostorder(root);
                break;

        }

    }

    private void addElementsInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        addElementsInOrder(root.left);
        iterator.add(root);
        addElementsInOrder(root.right);
    }

    private void addElementsInPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        iterator.add(root);
        addElementsInOrder(root.left);
        addElementsInOrder(root.right);
    }

    private void addElementsInPostorder(TreeNode root) {
        if (root == null) {
            return;
        }
        addElementsInOrder(root.left);
        addElementsInOrder(root.right);
        iterator.add(root);
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(root, 0);

        while (iterator.hasNext()){
            System.out.print(iterator.next().val + " ");
        }
    }

    @Override
    public boolean hasNext() {
        return iterator.size() > 0;
    }

    @Override
    public TreeNode next() {
        if (iterator.size() == 0) {
            throw new NoSuchElementException("Empty");
        }
        return iterator.poll();
    }

    public void clear() {
        if (iterator.size() == 0) {
            throw new NoSuchElementException("Empty");
        }
        iterator.clear();
    }
}
