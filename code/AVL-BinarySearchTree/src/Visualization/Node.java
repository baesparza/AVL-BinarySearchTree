package Visualization;

import Tree.TreeNode;

/**
 * Struct node used for plotting a Tree
 *
 * @author baesparza
 */
public class Node {

    final public TreeNode node;
    final public boolean valid;
    final public int x, y;

    /**
     * COnstructor when point exists
     *
     * @param data pointer to TreeNode
     * @param x position on x
     * @param y position on y
     */
    public Node(TreeNode data, int x, int y) {
        this.node = data;
        this.valid = true;
        this.x = x;
        this.y = y;
    }

    /**
     * COnstructor when point doesn't exists
     *
     * @param valid
     */
    public Node(boolean valid) {
        this.valid = valid;
        this.node = null;
        this.x = this.y = 0;
    }
}
