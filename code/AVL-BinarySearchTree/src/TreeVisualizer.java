
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
        setSize(600, 600);
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
    private int size;

    public void setPoints(TreePoint[][] points) {
        this.points = points;
        this.size = 600;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

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
        g.drawString("H", 0,10);
    }

}
