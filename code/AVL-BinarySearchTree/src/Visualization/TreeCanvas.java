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
        for (int i = 0; i < 20; i++) {
            root = avl.addNode(root, i);
        }
        this.graphData.setData(root);
        // this.graphData.printData();

        for (int i = 0; i < this.graphData.data.length; i++) {
            for (int j = 0; j < this.graphData.data[i].length; j++) {
                if (this.graphData.data[i][j].valid) {
                    g.drawString(String.valueOf(this.graphData.data[i][j].node.value), // node
                            this.graphData.data[i][j].x, // width
                            this.graphData.data[i][j].y // height
                    );
                    g.drawOval(
                            this.graphData.data[i][j].x - 15, // width
                            this.graphData.data[i][j].y - 15, // height
                            30, 30
                    );
                }
            }
        }
        /*draw lines*/
        for (int i = 1, temp1 = 0; i < this.graphData.data.length; i++, temp1 = 0) {
            for (int j = 0, period = 0; j < this.graphData.data[i].length; j++, period++) {
                if (period >= 2) {
                    temp1++;
                    period = 0;
                }
                if (this.graphData.data[i][j].valid) {
                    g.drawLine(
                            this.graphData.data[i - 1][temp1].x, // start x
                            this.graphData.data[i - 1][temp1].y, // start y
                            this.graphData.data[i][j].x, // end x
                            this.graphData.data[i][j].y // end y
                    );
                }
            }
        }
    }

}
