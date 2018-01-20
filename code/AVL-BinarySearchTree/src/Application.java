
/**
 *
 * @author baesparza
 */
public class Application {

    public static void main(String[] args) {
        
        AVL avl = new AVL();// methods to work with AVL tree
        BinarySearchTree bst = new BinarySearchTree();// methods to work with binary search tree
        TreeGraph plot = new TreeGraph(); // transfor array to array to plot
        TreeNode root = null; // root of the new tree

        /*add this nodes*/
        for (int i = 0; i <= 5; i++) root = avl.addNode(root, i);
        //root = avl.addNode(root, 3);
        //root = avl.addNode(root, 4);
        //root = avl.addNode(root, 2);
        //root = avl.addNode(root, 1);

        // print tree
        System.out.println("Tree:\nv, h");
        bst.traverse(root);
        
        
        TreePoint[][] points = plot.getData(root);
        System.out.println("\n\nDATA\nd, v");
        plot.printData();
        
        
        /*
        // remove this nodes
        root = avl.removeNode(root, 1);
        //root = avl.removeNode(root, 2);
        root = avl.removeNode(root, 3);
        //root = avl.removeNode(root, 4);
        //root = avl.removeNode(root, 5);
        //root = avl.removeNode(root, 6);
        root = avl.removeNode(root, 10);
        // print tree after nodes were removed
        System.out.println("\nTree:");
        bst.traverse(root);
        */
    }

}
