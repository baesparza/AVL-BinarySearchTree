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
     * Fix AVL property
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
        // with the height calculate the balance of each node
        this.calculateBalance(tree);
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
    
    /**
     * Calculate balance of every node
     * based on the height
     * @param tree to calculate balance property
     */
    public void calculateBalance(TreeNode tree) {
        // if no node return
        if (tree == null) return;
        
        // left.height - right.height
        // if left is bigger result is 2 or 1
        // if right is bigger result is -2 or -1
        // if both are balanced result is 0
        tree.balance = 
                ((tree.left != null) ? tree.left.height : -1) - 
                ((tree.right != null) ? tree.right.height : -1);
        
        // visit and calculate left and right node balance recursive
        this.calculateBalance(tree.left); 
        this.calculateBalance(tree.right); 
    }
    
    private TreeNode leftLeftRotation(TreeNode tree) {
        return tree;
    }
    
    /**
     * Check if each node is balanced
     * @param tree to be balanced
     * @return balanced tree
     */
    private TreeNode fixAVLProperty(TreeNode tree) {
        // check if we are in a node
        if (tree == null) return null;
        
        // balance tree first
        // then visit branches
        // since tree will be balance each insertion or deletion
        if (tree.balance == -2){
            // right branch is unbalance
            if (tree.left.balance == -1) {
                // double rotation
                
            }
            if (tree.left.balance == 1) {
                // sinple rotation
            }
        }
        if (tree.balance == 2) {
            // left branch is unbalance
            if (tree.right.balance == -1) {
                // sinple rotation
            }
            if (tree.right.balance == 1) {
                // double rotation
            }
        }
        
        // tree is balanced
        return tree;
    } 
    
}
