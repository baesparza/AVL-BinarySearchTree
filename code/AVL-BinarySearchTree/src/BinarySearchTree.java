/**
 *
 * @author baesparza
 */


/**
 * Methods to work with BST
 */
public class BinarySearchTree {
    /**
     * Traverse tree in order
     * @param tree tree to be printed
     */
    public void traverse(TreeNode tree) {
        // check if we are in a node
        if (tree == null) return;
        this.traverse(tree.left);
        System.out.println(tree.value + ", " + tree.height);
        this.traverse(tree.right);
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
        return tree;
    }
}
