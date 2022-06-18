package tree;

public class Tree {

    int data;
    Tree left;
    Tree right;

    Tree(int data) {
        this.data = data;
    }


    Tree(int[] values) {
        if (values.length == 0) {
            return;
        }
        Tree root = new Tree(values[0]);
        Tree current = root;
        for (int i = 1; i < values.length; i++) {
            if (values[i] < current.data) {
                if (current.left == null) {
                    current.left = new Tree(values[i]);
                }
                current = current.left;
            }
            else {
                if (current.right == null) {
                    current.right = new Tree(values[i]);
                }
                current = current.right;
            }
        }
        this.data = root.data;
    }

    public static void print(Tree tree) {
        if (tree == null) {
            return;
        }
        print(tree.left);
        System.out.print(tree.data + " ");
        print(tree.right);
    }
}
