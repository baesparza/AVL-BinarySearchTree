package Visualization;

import Tree.TreeNode;
import java.awt.Canvas;
import java.awt.Graphics;

/**
 *
 * @author baesparza
 */
public class TreeCanvas extends Canvas {

    public NodeMetadata nodeMetadata; // stored graphData
    public TreeNode tree;

    /**
     * Initialize graphData
     *
     * @param size of the canvas
     */
    public TreeCanvas(int size) {
        this.nodeMetadata = new NodeMetadata(size);

        /*Initialize data*/
        this.tree = null;
    }

    /**
     * Paint tree
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        this.drawNodes(this.tree, g);
        
        /*draw nodes*/
 /*
        for (Node[] row : this.graphData.data) {
            for (Node node : row) {
                if (node.valid) {
                    g.drawString(String.valueOf(node.node.value), // node
                            node.x, // x
                            node.y // y
                    );
                    g.drawOval(node.x - 15, // x
                            node.y - 15, // y
                            30, 30 // height and width of circle
                    );
                }
            }
        }
        /*draw lines*/
 /*
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
         */
    }

    private void drawNodes(TreeNode tree, Graphics g) {
        if (tree == null) {
            return;
        }
        g.drawString(String.valueOf(tree.value), // node
                tree.pos_x, // x
                tree.pos_y // y
        );
        this.drawNodes(tree.left, g);
        this.drawNodes(tree.right, g);
    }

}
