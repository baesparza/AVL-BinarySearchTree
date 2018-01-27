package Tree;

/**
 * Struct node used for Tree
 *
 * @author baesparza
 */
public class TreeNode {

    public TreeNode left, right;
    public int value, height;

    /**
     * Constructor initialize data and pointer to other nodes
     *
     * @param value data to be stored in this node
     */
    public TreeNode(int value) {
        this.value = value;
        this.height = 0;
        this.left = this.right = null;
    }
}
