/**
 *
 * @author baesparza
 */
public class TreeGraph {
    
    private TreePoint[][] data;
    private int[] positions;
    
    /**
     * Traverse tree and fill data
     * @param tree access point to tree
     * @param depth height from the root, used to know row were data belong
     */
    private void trasnformData(TreeNode tree, int depth) {
        /*might generate an infinite loop, if index out of range, stop pushing elemnts*/
        
        // check if we are in null a node
        if (tree == null) {
            try {
                // push new item
                this.data[depth][this.positions[depth]] = new TreePoint(false);
                this.positions[depth]++;
                // push back null pointes
                this.trasnformData(null, depth + 1);
                this.trasnformData(null, depth + 1);
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                // stop pushin elements when index is out of range
            }
            return;
        }
        // push this node data
        this.data[depth][this.positions[depth]] = new TreePoint(tree.value);
        this.positions[depth]++;
        // push branches data
        this.trasnformData(tree.left, depth + 1);
        this.trasnformData(tree.right, depth + 1);
    }
    
    /**
     * Reset Arrays and returns new array with data
     * @param tree TreeNode access point
     * @return Matrix of data
     */
    public TreePoint[][] getData(TreeNode tree) {
        /**
         * instantiate new matrix(not rectangular) based on height
         *   0  1  2  3  4  5  6  7
         * 0 []      
         * 1 [] []    
         * 2 [] [] [] []    
         * 3 [] [] [] [] [] [] [] []
         */
       
        // reset both arrays
        this.data = new TreePoint[tree.height + 1][]; // main data
        this.positions = new int[tree.height + 1]; // know positions of every node
        
        // i is index of array; size number of spaces per row and duplicate each loop
        // set positions to 0
        for (int i = 0, size = 1; i < this.data.length; i++, size += size){
            this.data[i] = new TreePoint[size];
            this.positions[i] = 0;
        }
        
        // fill data array
        this.trasnformData(tree, 0);
        
        // return filled data
        return this.data;
    }
    
    /**
     * Print array
     */
    public void printData() {
        for (TreePoint[] row: this.data){
            for (TreePoint data: row) {
                System.out.println(data.data + ", " + data.valid);
            }
            System.out.println("-----");
        }
    }

}
