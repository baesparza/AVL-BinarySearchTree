
/**
 *
 * @author baesparza
 */

/**
 * Struct node used for Tree
 */
class TreeNode {
    public TreeNode left, right;
    public int value;
    /**
     * Constructor initialize data and pointer to other nodes
     * @param value data to be stored in this node
     */
    public TreeNode(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}

/**
 * Methods to work with BST
 */
class BinarySearchTree {
    /**
     * Traverse tree in order
     * @param tree tree to be printed
     */
    public void printInOrder(TreeNode tree) {
        // check if we are in a node
        if (tree == null) return;
        this.printInOrder(tree.left);
        System.out.print(tree.value + " ");
        this.printInOrder(tree.right);
    } 
    
    /**
     * Add new node to binary search tree
     * @param tree were new node will be added
     * @param num data that will be added to the tree
     * @return tree with new node
     */
    public TreeNode addNode(TreeNode tree, int num) {
        // check if we are in a tree
        if (tree == null) {
            return new TreeNode(num);
        }
        
        /*add node to left or right branch*/
        // insert in left branch
        if (num < tree.value) {
            tree.left = this.addNode(tree.left, num);
            return tree;
        }
        // insert in right branch
        if (num > tree.value) {
            tree.right = this.addNode(tree.right, num);
            return tree;
        }
        
        /*node already in list*/
        return tree;
    }
    
    /**
     * Remove node from binary search tree
     * @param tree were node might be to be removed
     * @param num data needed to be removed
     * @return tree were data was removed
     */
    public TreeNode removeNode(TreeNode tree, int num) {
        // check if we are in a node
        if (tree == null) return null;
        
        /*remove node from left or right branch*/
        // go into left branch
        if (num < tree.value) {
            tree.left = this.removeNode(tree.left, num);
            return tree;
        }
        // go into right branch
        if (num > tree.value) {
            tree.right = this.removeNode(tree.right, num);
            return tree;
        }
        
        /*remove this node*/
        if (tree.value == num) {
            /*check if we are in a leaf*/
            if (tree.right == null && tree.left == null) // unlink this node
                return null;
            /*Search node to replace this*/
            TreeNode current = null; // iterator to search replacement
            if (tree.left != null) {
                // search max value in left branch
                current = tree.left;
                while (current.right != null) // stop before null node
                    current = current.right;
                /*change values*/
                tree.value = current.value;
                tree.left = this.removeNode(tree.left, tree.value);
            } else {
                // search min value in right branch
                current = tree.right;
                while (current.left != null) // stop before null node
                    current = current.left;
                /*change values*/
                tree.value = current.value;
                tree.right = this.removeNode(tree.right, tree.value);
            }
        }
        
        /*Value never existed in tree*/
        return tree;
    }
}

/**
 * Methods for AVL-BST
 */
class AVL extends BinarySearchTree{
    /**
     * Add node to tree
     * 
     * @param tree were new node will be added
     * @param num data that will be added to the tree
     * @return tree with new node
     */
    @Override
    public TreeNode addNode(TreeNode tree, int value) {
        // add node as normal to tree
        tree = super.addNode(tree, value);
        return tree;
    }
    
    /**
     * Remove node from tree
     * 
     * @param tree were node might be to be removed
     * @param num data needed to be removed
     * @return tree were data was removed
     */
    @Override
    public TreeNode removeNode(TreeNode tree, int value) {
        tree = super.removeNode(tree, value);
        return tree;
    }
}

class Application {
    
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
