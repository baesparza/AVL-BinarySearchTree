package Visualization;

import Tree.TreeNode;

/**
 * Manage meta data for each node
 *
 * @author baesparza
 */
public class NodeMetadata {

    private int[] positions, items; // positions and items per row
    final public int size, heightSeparation; // metadata for canvas

    /**
     * set size for the canvas
     *
     * @param size width
     */
    public NodeMetadata(int size) {
        this.size = size;
        this.heightSeparation = 50;
    }

    /**
     * Update parents of nodes by linking, depth of a node and position of node
     * x and y
     *
     * @param current node were parent will be linked
     * @param depth distance from the root tho this node
     */
    public void updateMetadata(TreeNode current, int depth) {
        if (current == null) {
            try {
                this.positions[depth]++;
                // push back null pointes
                this.updateMetadata(null, depth + 1);
                this.updateMetadata(null, depth + 1);
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                // stop pushin elements when index is out of range
            }
            return;
        }

        current.pos_y = (depth + 1) * this.heightSeparation;
        current.pos_x = ((this.size / this.items[depth]) / 2) + (this.size / this.items[depth] * this.positions[depth]);

        this.positions[depth]++; // increment index's

        this.updateMetadata(current.left, depth + 1);
        this.updateMetadata(current.right, depth + 1);
    }

    /**
     * Reset Arrays with use full data for nodes
     *
     * @param tree TreeNode access point
     */
    public void setData(TreeNode tree) {
        if (tree == null) { // check if we are in a node
            // set arrays to 0
            this.positions = new int[0];
            this.items = new int[0];
            return;
        }
        // reset both arrays
        this.positions = new int[tree.height + 1]; // keep trak of the position
        this.items = new int[tree.height + 1]; // nodes per wor

        // i is index of array; size number of spaces per row and duplicate each loop
        for (int i = 0, elements_row = 1; i < tree.height + 1; i++, elements_row *= 2) {
            this.positions[i] = 0; // set positions to 0
            this.items[i] = elements_row;
        }
        this.updateMetadata(tree, 0);

    }
}
