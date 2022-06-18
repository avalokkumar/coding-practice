package tree;

//Find the predecessor and successor a tree node in a binary search tree

//                                        10
//                                       /  \
//                                      5    15
//                                     / \   / \
//                                    2   7 12  17

public class PredecessorAndSuccessor {

    public static void main(String[] args) {
        Tree root = new Tree(10);
        root.left = new Tree(5);
        root.right = new Tree(15);
        root.left.left = new Tree(2);
        root.left.right = new Tree(7);
        root.right.left = new Tree(12);
        root.right.right = new Tree(17);

        int predecessor = findPredecessor(root, 10);
        System.out.println("Predecessor of 10 is " + predecessor);

        int successor = findSuccessor(root, 10);
        System.out.println("Successor of 10 is " + successor);
    }

    //Find the successor of a given node in a binary search tree
    private static int findSuccessor(Tree root, int val) {
        if (root == null) {
            return -1;
        }

        if (root.data == val) {
            if (root.right != null) {
                return findMin(root.right);
            } else {
                return -1;
            }
        } else if (root.data > val) {
            return findSuccessor(root.left, val);
        } else {
            return findSuccessor(root.right, val);
        }
    }

    private static int findPredecessor(Tree root, int val) {
        if (root == null) {
            return -1;
        }

        if (root.data == val) {
            if (root.left != null) {
                return findMax(root.left);
            } else {
                return -1;
            }
        } else if (root.data > val) {
            return findPredecessor(root.left, val);
        } else {
            return findPredecessor(root.right, val);
        }
    }

    private static int findMax(Tree left) {
        while (left.right != null) {
            left = left.right;
        }
        return left.data;
    }

    private static int findMin(Tree right) {
        while (right.left != null) {
            right = right.left;
        }
        return right.data;
    }
}
