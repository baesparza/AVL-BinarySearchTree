/**
 *
 * @author baesparza
 */
public class TreeGraph {
    
    private TreePoint[][] data;
    private int[] positions;
    
    private void trasnformData(TreeNode tree, int depth) {
        // check if we are in a node
        if (tree == null) {
            try {
                this.data[depth][this.positions[depth]] = new TreePoint(false);
                this.positions[depth]++;
                this.trasnformData(null, depth + 1);
                this.trasnformData(null, depth + 1);
                return;
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                // stop pushin elements when index is out of range
                return;
            }
        }
        this.data[depth][this.positions[depth]] = new TreePoint(tree.value);
        this.positions[depth]++;
        this.trasnformData(tree.left, depth + 1);
        this.trasnformData(tree.right, depth + 1);
    }
    
    public TreePoint[][] getData(TreeNode tree) {
        /**
         * instantiate new matrix(not rectangular) based on
         *   0  1  2  3  4  5  6  7
         * 0 []      
         * 1 [] []    
         * 2 [] [] [] []    
         * 3 [] [] [] [] [] [] [] []
         */
       
        this.data = new TreePoint[tree.height + 1][];
        this.positions = new int[tree.height + 1];
        
        // i is index of array; size number of spaces per row and duplicate each loop
        for (int i = 0, size = 1; i < this.data.length; i++, size += size){
            this.data[i] = new TreePoint[size];
            this.positions[i] = 0;
        }
        
        this.trasnformData(tree, 0);
        
        return this.data;
    }
    
    public void print() {
        for (TreePoint[] row: this.data) {
            for (TreePoint data: row) {
                System.out.println(data.data + ", " + data.valid);
            }
            System.out.println("-----");
        }
    }

}
