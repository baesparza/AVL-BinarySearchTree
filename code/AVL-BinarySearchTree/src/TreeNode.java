/**
 *
 * @author baesparza
 */


/**
 * Struct node used for Tree
 */
public class TreeNode {
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
