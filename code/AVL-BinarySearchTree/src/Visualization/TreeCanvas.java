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

        this.drawNodes(this.tree, g); // draw data
        this.drawLines(this.tree, g); // draw lines

    }

    private void drawNodes(TreeNode tree, Graphics g) {
        if (tree == null) {
            return;
        }
        g.drawString(String.valueOf(tree.value), tree.pos_x, tree.pos_y); // v, x, y
        this.drawNodes(tree.left, g);
        this.drawNodes(tree.right, g);
    }

    private void drawLines(TreeNode tree, Graphics g) {
        if (tree == null) {
            return;
        }
        if (tree.left != null) {
            g.drawLine(tree.left.pos_x, tree.left.pos_y, tree.pos_x, tree.pos_y); // sx, sy, ex, ey
        }
        if (tree.right != null) {
            g.drawLine(tree.right.pos_x, tree.right.pos_y, tree.pos_x, tree.pos_y); // sx, sy, ex, ey
        }
        this.drawLines(tree.left, g);
        this.drawLines(tree.right, g);
    }

}
