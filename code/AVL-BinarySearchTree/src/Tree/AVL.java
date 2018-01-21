package Tree;

 /**
 *
 * @author baesparza
 */

public class AVL{

    private final BinarySearchTree BST;

    public AVL() {
        this.BST = new BinarySearchTree();
    }
    
    /**
     * Add node to AVL Tree
     * @param tree were new node will be added
     * @param value data that will be added to the tree
     * @return tree with new node BALANCED
     */
    public TreeNode addNode(TreeNode tree, int value) {
        // add node as normal to tree
        tree = this.BST.addNode(tree, value);

        // update node`s height
        tree.height = this.calculateHeight(tree);

        // fix avl property
        tree = this.fixAVLProperty(tree); // return balanced tree
        
        // update node`s height
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
    public TreeNode removeNode(TreeNode tree, int value) {
        // remove node as normal
        tree = this.BST.removeNode(tree, value);
        
        // check if we still have nodes
        if (tree == null) return tree;
        
        // update node`s height
        tree.height = this.calculateHeight(tree);
        
        // fix avl property
        tree = this.fixAVLProperty(tree); // return balanced tree
        
        // update node`s height
        tree.height = this.calculateHeight(tree);
        
        return tree;
    }
    
    /**
     * Calculate longest path to a leaf
     * @param tree to calculate height
     * @return height of this node
     */
    private int calculateHeight(TreeNode tree) {
        // set height adding 1 to the longest path
        tree.height = Math.max(
                (tree.left != null) ? this.calculateHeight(tree.left) : -1, 
                (tree.right != null) ? this.calculateHeight(tree.right) : -1
        ) + 1;
        
        return tree.height;
    }
    
    /**
     * Calculate the balance of a node
     * @param tree node
     * @return balance
     */
    private int getBalance(TreeNode tree) {
        // if left is bigger result is 2 or 1 
        // if right is bigger result is -2 or -1
        // if both are iqual result is 0
        return ((tree.left != null) ? tree.left.height : -1) - 
                ((tree.right != null) ? tree.right.height : -1);
    }
    
    /**
     * Balance an unbalanced tree(z)
     * @param tree unbalanced
     * @return balanced tree
     */
    private TreeNode leftRotation(TreeNode z) {
        /**
         * Balance of z.right is 1 start at (1); else start at (2)
         * (1)          (2)               (3)
         *      /              /             /
         *     z              z             x
         *    / \            / \          /   \
         *   y   D   ->     x   D  ->    y     z
         *  / \            / \          / \   / \
         * A   x          y   C        A   B C   D
         *    / \        / \
         *   B   C      A   B
         * 
         * z has height of at least 2, y has height of at least 1 and
         * x has height of at least 0, so at the end x is a node
         */
    
        int balance = this.getBalance(z.left);
        
        if (balance == 1) {
            /*right rotate y*/
            TreeNode y = z.left; // y fo quick acces
            TreeNode x = y.right; // store x as a temp node
            y.right = x.left; // y.left = B
            x.left = y;
            z.left = x;
        }
        /*left rotate z*/
        TreeNode x = z.left; // store x as a temp node
        z.left = x.right; // z.right = C
        x.right = z;
        
        x.height = this.calculateHeight(x); // update node`s height
        
        return x; // return x as new root of the tree
    }
    
    /**
     * Balance an unbalanced tree(z)
     * @param tree unbalanced
     * @return balanced tree
     */
    private TreeNode RightRotation(TreeNode z) {
        /**
         * Balance of z.right is 1 start at (1); else start at (2)
         * (1)          (2)               (3)
         *  \            \                 \
         *   z            z                 x
         *  / \          / \              /   \
         * A   y    ->  A   x      ->    z     y
         *    / \          / \          / \   / \
         *   x   D        B   y        A   B C   D
         *  / \              / \ 
         * B   C            C   D
         * z has height of at least 2, y has height of at least 1 and
         * x has height of at least 0, so at the end x is a node
         */
    
        int balance = this.getBalance(z.right);
        
        if (balance == 1) {
            /*left rotate y*/
            TreeNode y = z.right; // y fo quick acces
            TreeNode x = y.left; // store x as a temp node
            y.left = x.right; // y.left = C
            x.right = y;
            z.right = x;
        }
        /*right rotate z*/
        TreeNode x = z.right; // store x as a temp node
        z.right = x.left; // z.right = B
        x.left = z;
        
        x.height = this.calculateHeight(x); // update node`s height
        
        return x; // return x as new root of the tree
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
        
        int balance = this.getBalance(tree); // get balance factor of this node
        
        /*if unbalanced, balance it*/
        if (balance == -2){
            // right branch is unbalance
            tree = this.RightRotation(tree);
        } else if (balance == 2) {
            // left branch is unbalance
            tree = this.leftRotation(tree);
        }
        return tree;
    } 
    
}
