package Visualization;


/**
 *
 * @author baesparza
 */
import java.awt.*;
import javax.swing.*;

public class TreeVisualizer extends JFrame {

    public TreeVisualizer(MyCanvas canvas) {
        canvas = new MyCanvas();
        setLayout(new BorderLayout());
        setSize(600, 600);
        setTitle("BST Visualizer");
        add("Center", canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // center screen
        setLocationRelativeTo(null);

        setVisible(true);
    }
    
}