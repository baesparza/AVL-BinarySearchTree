package Application;


import Visualization.TreeVisualizer;
import Visualization.MyCanvas;
import Visualization.TreeGraph;
import Tree.TreeNode;
import Visualization.TreePoint;
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
        TreeGraph plot = new TreeGraph(); // transfor array to array to plot
        MyCanvas canvas = new MyCanvas(); // initialize canvas
        TreeVisualizer frame = new TreeVisualizer(canvas); // canvas
        
        TreeNode root = null; // root of the new tree
        TreePoint[][] points; // data for visualizing
        
        /*MENU*/
        int opc;
        while (true) {
            // check valid input
            do {
                opc = inputMessage("Select an option\n1. Insert\n2. Delete\n0. Exit\n-> ");
            } while (opc < 0 || opc > 2);
            // menu options
            switch(opc){
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
            System.out.println("Tree:\nv, h");
            bst.traverse(root);
            // print plot
            points = plot.getData(root);
            System.out.println("Data:\nd, v");
            plot.printData();
            // Plot on canvas
            canvas.setPoints(points);
        }        
    }
    
    public static int inputMessage(String msg) {
        System.out.print(msg);
        return input.nextInt();
    }

}
