package Visualization;

import Tree.TreeNode;

/**
 *
 * @author baesparza
 */

/**
 * Struct node used for plotting a Tree
 */
public class Node {
    public TreeNode node;
    public boolean valid;
    public int x, y, totalSize;
    
    
    /**
     * COnstructor when point exists
     * @param data 
     */
    public Node(TreeNode data, int totalSize ) {
        this.node = data;
        this.valid = true;
        this.totalSize = totalSize;
    }
    /**
     * COnstructor when point doesn't exists
     * @param valid 
     */
    public Node(boolean valid) {
        this.valid = valid;
        this.node = null;
    }
}

