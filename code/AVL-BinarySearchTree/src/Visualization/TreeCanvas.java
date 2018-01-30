package Visualization;

import java.awt.Canvas;
import java.awt.Graphics;

/**
 *
 * @author baesparza
 */
public class TreeCanvas extends Canvas {

    public GraphData graphData; // stored graphData

    /**
     * Initialize graphData
     *
     * @param size of the canvas
     */
    public TreeCanvas(int size) {
        this.graphData = new GraphData(size);

        /*Initialize data*/
        this.graphData.setData(null);
    }

    /**
     * Paint tree
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        /*draw nodes*/
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
