package Application;

import Visualization.Visualizer;
import Tree.TreeNode;
import Tree.AVL;
import Visualization.NodeMetadata;
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

        int size = 800; // size of canvas

        AVL avl = new AVL();// methods to work with AVL tree
        Visualizer frame = new Visualizer(size); // window
        NodeMetadata nodeMetadata = new NodeMetadata(size); // stored graphData

        TreeNode root = null; // root of the new tree

        /*MENU*/
        int opc;
        while (true) {
            // check valid input
            do {
                opc = inputMessage("Select an option\n1. Insert\n2. Delete\n3. Print\n0. Exit\n-> ");
            } while (opc < 0 || opc > 3);
            // menu options
            switch (opc) {
                case 0:
                    System.exit(0);
                case 1: // add node
                    root = avl.addNode(root, inputMessage("Insert a number: "));
                    break;
                case 2: // remove node
                    root = avl.removeNode(root, inputMessage("Insert a number: "));
                    break;
                case 3: // print tree on console
                    System.out.println("Tree:");
                    avl.traverse(root);
                    System.out.println();
                    break;
            }
            // update frame
            nodeMetadata.setData(root);
            frame.repaintTree(root);
        }
    }

    public static int inputMessage(String msg) {
        System.out.print(msg);
        return input.nextInt();
    }

}
