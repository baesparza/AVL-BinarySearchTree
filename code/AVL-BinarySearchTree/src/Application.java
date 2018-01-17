/**
 *
 * @author baesparza
 */


public class Application {
    
    public static void main(String[] args) {
        // methods to work with
        AVL bst = new AVL();
        // root of the new tree
        TreeNode root = null;
        
        /*add this nodes*/
        root = bst.addNode(root, 7);
        root = bst.addNode(root, 2);
        root = bst.addNode(root, 7);
        root = bst.addNode(root, 8);
        root = bst.addNode(root, 1);
        root = bst.addNode(root, 4);
        root = bst.addNode(root, 5);
        root = bst.addNode(root, 3);
        root = bst.addNode(root, 2);
        root = bst.addNode(root, 10);
        root = bst.addNode(root, 9);
        
        // print tree
        System.out.println("Tree:");
        bst.printInOrder(root);
        
        // remove this nodes
        root = bst.removeNode(root, 10);
        root = bst.removeNode(root, 5);
        
        // print tree after nodes were removed
        System.out.println("\nTree:");
        bst.printInOrder(root);
    }
    
}
