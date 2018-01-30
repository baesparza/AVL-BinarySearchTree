package Tree;

/**
 * Struct node used for Tree
 *
 * @author baesparza
 */
public class TreeNode {

    public TreeNode left, right, parent;
    public int value, height;
    public int pos_x, pos_y;

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
