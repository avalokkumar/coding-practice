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
        addElementsInOrder(root.leftChild);
        iterator.add(root);
        addElementsInOrder(root.rightChild);
    }

    private void addElementsInPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        iterator.add(root);
        addElementsInOrder(root.leftChild);
        addElementsInOrder(root.rightChild);
    }

    private void addElementsInPostorder(TreeNode root) {
        if (root == null) {
            return;
        }
        addElementsInOrder(root.leftChild);
        addElementsInOrder(root.rightChild);
        iterator.add(root);
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.leftChild = new TreeNode(9);
        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);

        root.rightChild = new TreeNode(20);
        root.rightChild.leftChild = new TreeNode(15);
        root.rightChild.rightChild = new TreeNode(7);
        BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(root, 0);

        while (iterator.hasNext()){
            System.out.print(iterator.next().data + " ");
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
