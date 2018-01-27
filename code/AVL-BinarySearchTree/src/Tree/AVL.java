package Tree;

/**
 *
 * @author baesparza
 */
public class AVL {

    /**
     * Traverse tree in order
     *
     * @param tree tree to be printed
     */
    public void traverse(TreeNode tree) {
        // check if we are in a node
        if (tree == null) {
            return;
        }
        this.traverse(tree.left);
        System.out.println("\t" + tree.value + ", " + tree.height);
        this.traverse(tree.right);
    }

    /**
     * Add node to AVL Tree
     *
     * @param tree were new node will be added
     * @param value data that will be added to the tree
     * @return tree with new node BALANCED
     */
    public TreeNode addNode(TreeNode tree, int value) {
        // check if we hae a node
        if (tree == null) {
            return new TreeNode(value);
        }

        // insert node recursively
        if (tree.value == value) {
            return tree;
        } else if (value < tree.value) {
            tree.left = this.addNode(tree.left, value);
        } else if (value > tree.value) {
            tree.right = this.addNode(tree.right, value);
        }

        // update height of this node
        tree.height = max(this.getHeight(tree.left), this.getHeight(tree.right)) + 1;

        // fix avl property
        int balance = this.getBalance(tree); // get balance factor of this node

        // if tree is unbalanced, there are 4 cases
        if (balance == -2 && value > tree.right.value) {
            return this.rightRotation(tree);
        }
        // left left rotation
        if (balance == 2 && value < tree.left.value) {
            return leftRotation(tree);
        }
        // right left rotation
        if (balance == -2 && value < tree.right.value) {
            tree.right = leftRotation(tree.right);
            return rightRotation(tree);
        }
        // left right rotation
        if (balance == 2 && value > tree.left.value) {
            tree.left = rightRotation(tree.left);
            return leftRotation(tree);
        }

        // return balanced tree
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
        // check if we are in a node
        if (tree == null) {
            return null;
        }

        // remove node with bst remove method
        if (value < tree.value) {
            tree.left = this.removeNode(tree.left, value);
        } else if (value > tree.value) {
            tree.right = this.removeNode(tree.right, value);
        } else if (tree.value == value) {
            /*check if we are in a leaf*/
            if (tree.right == null && tree.left == null) {
                return null;
            }

            /*Search node to replace this*/
            TreeNode current = null; // iterator to search replacement
            if (tree.left != null) {
                // search max value in left branch
                current = tree.left;
                while (current.right != null) // stop before null node
                {
                    current = current.right;
                }
                /*change values*/
                tree.value = current.value;
                tree.left = this.removeNode(tree.left, tree.value);
            } else {
                // search min value in right branch
                current = tree.right;
                while (current.left != null) // stop before null node
                {
                    current = current.left;
                }
                /*change values*/
                tree.value = current.value;
                tree.right = this.removeNode(tree.right, tree.value);
            }
            return tree;
        }

        // check if we are in a node
        if (tree == null) {
            return null;
        }

        // update height of this node
        tree.height = max(this.getHeight(tree.left), this.getHeight(tree.right)) + 1;

        // fix avl property
        int balance = this.getBalance(tree); // get balance factor of this node

        // if tree is unbalanced, there are 4 cases
        if (balance == -2 && this.getBalance(tree.right) == -1) {
            return this.rightRotation(tree);
        }
        // left left rotation
        if (balance == 2 && this.getBalance(tree.left) == 1) {
            return leftRotation(tree);
        }
        // right left rotation
        if (balance == -2 && this.getBalance(tree.right) == 1) {
            tree.right = leftRotation(tree.right);
            return rightRotation(tree);
        }
        // left right rotation
        if (balance == 2 && this.getBalance(tree.left) == -1) {
            tree.left = rightRotation(tree.left);
            return leftRotation(tree);
        }

        // return balanced tree
        return tree;
    }

    /**
     * basic function to get max of two numbers
     *
     * @param a first number
     * @param b second number
     * @return max of both numbers
     */
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * Calculate height of a node
     *
     * @param tree to calculate height
     * @return height of this node
     */
    private int getHeight(TreeNode tree) {
        return (tree != null) ? tree.height : -1;
    }

    /**
     * Calculate the balance of a node
     *
     * @param tree node
     * @return balance
     */
    private int getBalance(TreeNode tree) {
        return (tree != null) ? this.getHeight(tree.left) - this.getHeight(tree.right) : 0;
    }

    /**
     * Balance an unbalanced tree(z)
     *
     * @param tree unbalanced
     * @return balanced tree
     */
    private TreeNode leftRotation(TreeNode x) {
        //       /          /
        //      x          y
        //     / \        / \
        //    y   C  ->  A   x
        //   / \            / \
        //  A   B          B   C
        TreeNode y = x.left;

        // rotate
        x.left = y.right;
        y.right = x;

        // update heights
        x.height = max(this.getHeight(x.left), this.getHeight(x.right)) + 1;
        y.height = max(this.getHeight(y.left), this.getHeight(y.right)) + 1;

        // return y as new tree
        return y;
    }

    /**
     * Right rotate of x
     *
     * @param tree unbalanced
     * @return balanced tree
     */
    private TreeNode rightRotation(TreeNode x) {
        //   \              \
        //    x              y
        //   / \            / \
        //  A   y    ->    x   C
        //     / \        / \
        //    B   C      A   B

        TreeNode y = x.right;

        // rotate
        x.right = y.left;
        y.left = x;

        // update heights
        x.height = max(this.getHeight(x.left), this.getHeight(x.right)) + 1;
        y.height = max(this.getHeight(y.left), this.getHeight(y.right)) + 1;

        // return y as new tree
        return y;
    }
}
