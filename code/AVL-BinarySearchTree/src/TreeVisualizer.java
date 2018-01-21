/**
 *
 * @author baesparza
 */

import java.awt.*;
import javax.swing.*;


class TreeVisualizer extends JFrame {

    private final MyCanvas canvas;
    
    public TreeVisualizer(TreePoint[][] points) {
        this.canvas = new MyCanvas();
        setLayout(new BorderLayout());
        setSize(500, 500);
        setTitle("BST Visualizer");
        add("Center", this.canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // center screen
        setLocationRelativeTo(null);
        
        setVisible(true);
        this.canvas.setPoints(points);
    }
}

class MyCanvas extends Canvas {
    
    private TreePoint[][] points;

    public void setPoints(TreePoint[][] points) {
        this.points = points;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < this.points.length; i++) {
            for (int j = 0; j < this.points[i].length; j++) {
                if (this.points[i][j].valid)
                    g.drawString(this.points[i][j].data + "", (j + 1) * 500/(this.points[i].length + 1), 30 * (i + 1));
            }
        }
    }
    
}
