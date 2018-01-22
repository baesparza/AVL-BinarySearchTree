package Visualization;

/**
 * Class to manage frame
 *
 * @author baesparza
 */
import java.awt.*;
import javax.swing.*;

public class Visualizer extends JFrame {
    
    public TreeCanvas canvas;

    public Visualizer(int size) {
        this.canvas = new TreeCanvas(size);
        setLayout(new BorderLayout());
        setSize(size, size);
        setTitle("AVL Tree Visualizer");
        add("Center", this.canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // center screen
        setLocationRelativeTo(null);

        setVisible(true);
    }

}
