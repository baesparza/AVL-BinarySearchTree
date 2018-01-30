package Visualization;

/**
 * Class to manage frame
 *
 * @author baesparza
 */
import Tree.TreeNode;
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

    /**
     * Repaint canvas with new data
     *
     * @param tree new data to update
     */
    public void repaintTree(TreeNode tree) {
        this.canvas.tree = tree;// set new meta data
        this.canvas.nodeMetadata.setData(tree); // update new metadata
        this.canvas.repaint(); // repaint
    }

}
