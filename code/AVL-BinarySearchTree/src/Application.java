
/**
 *
 * @author baesparza
 */
public class Application {

    public static void main(String[] args) {
        
        AVL avl = new AVL();// methods to work with AVL tree
        BinarySearchTree bst = new BinarySearchTree();// methods to work with binary search tree
        // root of the new tree
        TreeNode root = null;

        /*add this nodes*/
        for (int i = 1; i <= 5; i++) root = avl.addNode(root, i);
        //root = avl.addNode(root, 3);
        //root = avl.addNode(root, 4);
        //root = avl.addNode(root, 2);
        //root = avl.addNode(root, 1);

        
        // print tree
        System.out.println("Tree:\nv, h");
        bst.traverse(root);
        
        // transfor array to array to plot
        TreeGraph plot = new TreeGraph();
        
        
        plot.getData(root);
        System.out.println("\n\nDATA\nd, v");
        plot.print();
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
