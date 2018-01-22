package Visualization;

import Tree.TreeNode;

/**
 * Class that contains all the data for the graph
 *
 * @author baesparza
 */
public class GraphData {

    public Node[][] data; // metadata
    private int[] positions, items; // positions and items per row
    final public int size, heightSeparation; // metadata for canvas

    /**
     * set size for the canvas
     * @param size width
     */
    public GraphData(int size) {
        this.size = size;
        this.heightSeparation = 50;
    }

    /**
     * Traverse tree and fill node
     *
     * @param tree access point to tree
     * @param depth height from the root, used to know row were node belong
     */
    private void trasnformData(TreeNode tree, int depth) {
        /*might generate an infinite loop, if index out of range, stop pushing elemnts*/

        // check if we are in null a node
        if (tree == null) {
            try {
                // push new item
                this.data[depth][this.positions[depth]] = new Node(false);
                this.positions[depth]++;
                // push back null pointes
                this.trasnformData(null, depth + 1);
                this.trasnformData(null, depth + 1);
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                // stop pushin elements when index is out of range
            }
            return;
        }
        // push this node node
        this.data[depth][this.positions[depth]] = new Node(
                tree,
                this.heightSeparation * (this.positions[depth] + 1), // x
                ((this.size / this.items[depth]) / 2) + (this.size / this.items[depth] * depth) // y
        );
        this.positions[depth]++; // in
        // push branches node
        this.trasnformData(tree.left, depth + 1);
        this.trasnformData(tree.right, depth + 1);
    }

    /**
     * Reset Arrays and returns new array with node
     *
     * @param tree TreeNode access point
     */
    public void setData(TreeNode tree) {
        /**
         * instantiate new matrix(not rectangular) based on height
         *   0  1  2  3  4  5  6  7
         * 0 []      
         * 1 [] []    
         * 2 [] [] [] []    
         * 3 [] [] [] [] [] [] [] []
         */
        if (tree == null) { // check if we are in a node
            // set array to 0
            this.data = new Node[0][0];
            this.positions = this.items = new int[0];
            return;
        }
        // reset both arrays
        this.data = new Node[tree.height + 1][]; // main data
        // know positions of every node, and number of nodes per row
        this.positions = this.items = new int[tree.height + 1];

        // i is index of array; size number of spaces per row and duplicate each loop
        // set positions to 0
        for (int i = 0, size = 1; i < this.data.length; i++, size *= 2) {
            this.data[i] = new Node[size];
            this.positions[i] = 0;
            this.items[i] = size;
        }

        this.trasnformData(tree, 0); // fill node array
    }

    /**
     * Print data
     */
    public void printData() {
        for (Node[] row : this.data) {
            for (Node node : row) {
                System.out.println(node.node.value + ", " + node.valid);
            }
            System.out.println("-");
        }
    }

}
