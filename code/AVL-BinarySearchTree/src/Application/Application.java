package Application;

import Visualization.Visualizer;
import Tree.TreeNode;
import Tree.BinarySearchTree;
import Tree.AVL;
import java.util.Scanner;

/**
 *
 * @author baesparza
 */
public class Application {

    /**
     * Scanner to read user input
     */
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        AVL avl = new AVL();// methods to work with AVL tree
        BinarySearchTree bst = new BinarySearchTree();// methods to work with binary search tree
        Visualizer frame = new Visualizer(600); // window

        TreeNode root = null; // root of the new tree

        /*MENU*/
        int opc;
        while (true) {
            // check valid input
            do {
                opc = inputMessage("Select an option\n1. Insert\n2. Delete\n0. Exit\n-> ");
            } while (opc < 0 || opc > 2);
            // menu options
            switch (opc) {
                case 0:
                    System.exit(0);
                case 1:
                    root = avl.addNode(root, inputMessage("Insert a number: "));
                    break;
                case 2:
                    root = avl.removeNode(root, inputMessage("Insert a number: "));
                    break;
            }
            // print tree
            System.out.println("\tTree:\n\tv, h");
            bst.traverse(root);
            frame.repaintTree(root);
        }
    }

    public static int inputMessage(String msg) {
        System.out.print(msg);
        return input.nextInt();
    }

}
