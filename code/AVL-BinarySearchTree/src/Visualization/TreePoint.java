package Visualization;

/**
 *
 * @author baesparza
 */

/**
 * Struct node used for plotting a Tree
 */
public class TreePoint {
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

