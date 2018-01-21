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
public class MyCanvas extends Canvas {

    private TreePoint[][] points;
    private int size;
    
    public MyCanvas() {
        this.size = 600;
    }

    public void setPoints(TreePoint[][] points) {
        this.points = points;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        if (this.points != null)
        for (int i = 0, spaces = 1; i < this.points.length; i++, spaces *= 2) {
            for (int j = 0; j < this.points[i].length; j++) {
                if (this.points[i][j].valid) {
                    g.drawString(String.valueOf(this.points[i][j].data), // data
                            ((this.size / spaces) / 2) + (this.size / spaces * j), // width
                            50 * (i + 1) // height
                    );
                }
            }
        }
    }

}

