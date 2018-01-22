package Visualization;

import Tree.AVL;
import Tree.TreeNode;
import java.awt.Canvas;
import java.awt.Graphics;

/**
 *
 * @author baesparza
 */
public class TreeCanvas extends Canvas {

    public GraphData graphData; // stored graphData
    final int size;

    public TreeCanvas(int size) {
        this.graphData = new GraphData(size);
        this.size = size;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        
        AVL avl = new AVL();
        TreeNode root = null;
        for(int i = 0; i < 10; i++) root = avl.addNode(root, i);
        this.graphData.setData(root);
        // this.graphData.printData();
        
        
        for (int i = 0, spaces = 1; i < this.graphData.data.length; i++, spaces *= 2) {
            for (int j = 0; j < this.graphData.data[i].length; j++) {
                if (this.graphData.data[i][j].valid) {
                    g.drawString(String.valueOf(this.graphData.data[i][j].node.value), // node
                            this.graphData.data[i][j].y, // width
                            this.graphData.data[i][j].x // height
                    );
                    
                    //System.out.print(this.graphData.data[i][j].node.value + ", ");
                    //System.out.print(this.graphData.data[i][j].y+ ", ");
                    //System.out.println(this.graphData.data[i][j].x);
                }
            }
        }
    }

}
