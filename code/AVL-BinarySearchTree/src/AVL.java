/**
 *
 * @author Usuario
 */


/**
 * Methods for AVL-BST
 */
public class AVL extends BinarySearchTree{
    /**
     * Add node to tree
     * 
     * @param tree were new node will be added
     * @param value data that will be added to the tree
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
     * @param value data needed to be removed
     * @return tree were data was removed
     */
    @Override
    public TreeNode removeNode(TreeNode tree, int value) {
        tree = super.removeNode(tree, value);
        return tree;
    }
    
}
