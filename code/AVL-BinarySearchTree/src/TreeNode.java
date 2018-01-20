/**
 *
 * @author baesparza
 */


/**
 * Struct node used for Tree
 */
class TreeNode {
    public TreeNode left, right;
    public int value, height;
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
 * Struct node used for plotting a Tree
 */
class TreePoint {
    public int data;
    public boolean valid;
    /**
     * COnstructor when point exists
     * @param data 
     */
    public TreePoint(int data) {
        this.data = data;
        this.valid = true;
    }
    /**
     * COnstructor when point doesn't exists
     * @param valid 
     */
    public TreePoint(boolean valid) {
        this.valid = valid;
    }
}
