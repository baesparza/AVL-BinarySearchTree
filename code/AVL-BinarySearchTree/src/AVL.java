/**
 *
 * @author baesparza
 */


/**
 * Methods for AVL-BST
 */
public class AVL extends BinarySearchTree{
    /**
     * Add node to tree
     * Recalculate height of each node
     * 
     * @param tree were new node will be added
     * @param value data that will be added to the tree
     * @return tree with new node
     */
    @Override
    public TreeNode addNode(TreeNode tree, int value) {
        // add node as normal to tree
        tree = super.addNode(tree, value);
        // check height
        tree.height = this.calculateHeight(tree);
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
        // remove node as normal
        tree = super.removeNode(tree, value);
        
        // check if we still have nodes
        if (tree == null) return tree;
        
        // check height
        tree.height = this.calculateHeight(tree);
        return tree;
    }
    
    /**
     * Calculate longest path to a leaf
     * @param tree to calculate height
     * @return height of this node
     */
    public int calculateHeight(TreeNode tree) {
        // set height adding 1 to the longest path
        tree.height = Math.max(
                (tree.left != null) ? this.calculateHeight(tree.left) : -1, 
                (tree.right != null) ? this.calculateHeight(tree.right) : -1
        ) + 1;
        
        return tree.height;
    }
    
}
