package tree;

import java.util.Stack;

//Example of a tree
public class TreeExample {
    public static void main(String[] args) {

        // Create a new tree
        Tree root = new Tree(1);

        root.left = new Tree(2);
        root.right = new Tree(3);

        root.left.left = new Tree(4);
        root.left.right = new Tree(5);

        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        System.out.println("=============INORDER============");
        inorderTraverse(root);
        /*System.out.println("\n============PREORDER=============");
        preOrderTraverse(root);
        System.out.println("\n============POSTORDER=============");
        postOrderTraverse(root);*/

    }

    private static void inorderTraverseRec(Tree root) {

        if (root == null) {
            return;
        }

        inorderTraverse(root.left);
        System.out.print(root.data + " ");
        inorderTraverse(root.right);
    }

    //Traverse tree in non recursive way

    private static void inorderTraverse(Tree root) {
        if (root == null)
            return;

        Stack<Tree> s = new Stack<>();
        Tree curr = root;
        // traverse the tree
        while (curr != null || s.size() > 0)
        {
            while (curr !=  null)
            {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    private static void postOrderTraverse(Tree root) {
        if (root == null)
            return;

        Stack<Tree> s = new Stack<>();
        Tree curr = root;
        while (curr != null || s.size() > 0)
        {
            while (curr !=  null)
            {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    private static void postOrderTraverseRec(Tree root) {
        if (root == null) {
            return;
        }

        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.data + " ");
    }

    private static void preOrderTraverse(Tree root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }
}


//                1
//        2               3
//    4       5       6       7
