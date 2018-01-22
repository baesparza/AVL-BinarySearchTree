/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualization;

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

        /**
         * Here need to initialize data user for canvas
        // print plot
        points = plot.getData(root);
        System.out.println("Data:\nd, v");
        plot.printData();
        // Plot on canvas
        canvas.setPoints(points);
         */
        this.graphData.setData(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0, spaces = 1; i < this.graphData.data.length; i++, spaces *= 2) {
            for (int j = 0; j < this.graphData.data[i].length; j++) {
                if (this.graphData.data[i][j].valid) {
                    g.drawString(String.valueOf(this.graphData.data[i][j].node.value), // node
                            this.graphData.data[i][j].y, // width
                            this.graphData.data[i][j].x // height
                    );
                }
            }
        }
    }

}
