/**
 *
 * @author baesparza
 */

public class AVL{
    
    /**
     * simple methods from BinarySearchTree
     */
    private final BinarySearchTree BST = new BinarySearchTree();
    
    /**
     * Add node to AVL
     * @param tree were new node will be added
     * @param value data that will be added to the tree
     * @return tree with new node BALANCED
     */
    public TreeNode addNode(TreeNode tree, int value) {
        
        // add node as normal to tree
        tree = this.BST.addNode(tree, value);
        
        // fix avl property
        tree = this.fixAVLProperty(tree);
        
        /*With new node Calculate height and balance*/
        // update node height
        tree.height = this.calculateHeight(tree);
        // with the height calculate the balance of each node
        this.calculateBalance(tree);
        
        return tree; // return balanced tree
    }
    
    /**
     * Remove node from tree
     * 
     * @param tree were node might be to be removed
     * @param value data needed to be removed
     * @return tree were data was removed
     */
    public TreeNode removeNode(TreeNode tree, int value) {
        // remove node as normal
        tree = this.BST.removeNode(tree, value);
        
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
    
    /**
     *        /             /
     *       z             y
     *      / \          /   \
     *     y   D  ->    x     z
     *    / \          / \   / \
     *   x   C        A   B C   D
     *  / \
     * A   B
     * 
     * @param tree unbalanced
     * @return balanced tree
     */
    private TreeNode leftLeftRotation(TreeNode z) {
        // never use x since might be a null node
        TreeNode y = z.left; // store y as a temp node
        z.left = y.right; // z.left = C
        y.right = z;
        return y; // return y as new root of the tree
    }
    
    /**
     *      /              /             /
     *     z              z             x
     *    / \            / \          /   \
     *   y   D   ->     x   D  ->    y     z
     *  / \            / \          / \   / \
     * A   x          y   C        A   B C   D
     *    / \        / \
     *   B   C      A   B
     * 
     * @param tree unbalanced
     * @return balanced tree
     */
    private TreeNode leftRightRotation(TreeNode z) {
        // Right rotate of x
        z.left = this.RightRightRotation(z.left);
        // left rotate of z
        return this.leftLeftRotation(z);
    }
    
    /**
     *  \                 \
     *   z                 y
     *  / \              /   \
     * A   y      ->    z     x
     *    / \          / \   / \
     *   B   x        A   B C   D
     *      / \ 
     *     C   D  
     * @param tree unbalanced
     * @return balanced tree
     */
    private TreeNode RightRightRotation(TreeNode z) {
        // never use x since might be a null node
        TreeNode y = z.right; // store y as a temp node
        z.right = y.left; // z.right = B
        y.left = z;
        return y; // return y as new root of the tree
    }
    
    /**
     *  \            \                 \
     *   z            z                 x
     *  / \          / \              /   \
     * A   y    ->  A   x      ->    z     y
     *    / \          / \          / \   / \
     *   x   D        B   y        A   B C   D
     *  / \              / \ 
     * B   C            C   D  
     * @param tree unbalanced
     * @return balanced tree
     */
    private TreeNode RightLeftRotation(TreeNode z) {
        // left rotate y
        z.right = this.leftLeftRotation(z.right);
        // right rotate z
        return this.RightRightRotation(z);
    }
    
    /**
     * Check if each node is balanced
     * @param tree to be balanced
     * @return balanced tree
     */
    private TreeNode fixAVLProperty(TreeNode tree) {
        // check if we are in a node
        if (tree == null) return null;
        
        // balance branches first
        tree.left = this.fixAVLProperty(tree.left);
        tree.right = this.fixAVLProperty(tree.right);
        
        
        
        //recalculate balance of three if it changed
        // update node height
        tree.height = this.calculateHeight(tree);
        // with the height calculate the balance of each node
        this.calculateBalance(tree);  
        
        
        
        // right branch is unbalance
        if (tree.balance == -2){
            // double rotation
            if (tree.right.balance == 1) 
                tree = this.RightLeftRotation(tree);
            // sinple rotation
            else if (tree.right.balance == -1)
                tree = this.RightRightRotation(tree);
        }
        // left branch is unbalance
        else if (tree.balance == 2) {
            // sinple rotation
            if (tree.left.balance == 1) 
                tree = this.leftLeftRotation(tree);
            // double rotation
            else if (tree.left.balance == -1)
                tree = this.leftRightRotation(tree);
        }
        
        return tree;
    } 
    
}
