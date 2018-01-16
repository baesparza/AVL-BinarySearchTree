
/**
 *
 * @author baesparza
 */

class TreeNode {
    public TreeNode left, right;
    public int value;
    public TreeNode(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}

class BinarySearchTree {
    public TreeNode addNode(TreeNode tree, int value) {
        // check if we are in a tree
        if (tree == null) {
            return new TreeNode(value);
        }
        
        /*add node left or right branch*/
        // insert in right branch
        if (tree.value > value) {
            tree.right = this.addNode(tree.right, value);
            return tree;
        }
        // insert in left branch
        if (tree.value < value) {
            tree.left = this.addNode(tree.left, value);
            return tree;
        }
        
        /*node already in list*/
        return tree;
    }
}

class Application {

    public static void main(String[] args) {
        
        
    }
    
}
