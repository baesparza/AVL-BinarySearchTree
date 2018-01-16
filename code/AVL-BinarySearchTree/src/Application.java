
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
    public void printInOrder(TreeNode tree) {
        if (tree == null) return;
        this.printInOrder(tree.left);
        System.out.print(tree.value + " ");
        this.printInOrder(tree.right);
    } 
    
    public TreeNode addNode(TreeNode tree, int value) {
        // check if we are in a tree
        if (tree == null) {
            return new TreeNode(value);
        }
        
        /*add node left or right branch*/
        // insert in left branch
        if (value < tree.value) {
            tree.left = this.addNode(tree.left, value);
            return tree;
        }
        // insert in right branch
        if (value > tree.value) {
            tree.right = this.addNode(tree.right, value);
            return tree;
        }
        
        /*node already in list*/
        return tree;
    }
}

class Application {

    public static void main(String[] args) {
        
        BinarySearchTree bst = new BinarySearchTree();
        
        TreeNode root = null;
        
        root = bst.addNode(root, 3);
        root = bst.addNode(root, 1);
        root = bst.addNode(root, 4);
        root = bst.addNode(root, 2);
        root = bst.addNode(root, 5);
        
        bst.printInOrder(root);
    }
    
}
