
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
    
    public TreeNode addNode(TreeNode tree, int num) {
        // check if we are in a tree
        if (tree == null) {
            return new TreeNode(num);
        }
        
        /*add node to left or right branch*/
        // insert in left branch
        if (num < tree.value) {
            tree.left = this.addNode(tree.left, num);
            return tree;
        }
        // insert in right branch
        if (num > tree.value) {
            tree.right = this.addNode(tree.right, num);
            return tree;
        }
        
        /*node already in list*/
        return tree;
    }
    
    public TreeNode removeNode(TreeNode tree, int num) {
        if (tree == null) return null;
        
        /*remove node from left or right branch*/
        // go into left branch
        if (num < tree.value) {
            tree.left = this.removeNode(tree.left, num);
            return tree;
        }
        // go into right branch
        if (num > tree.value) {
            tree.right = this.removeNode(tree.right, num);
            return tree;
        }
        
        /*remove this node*/
        if (tree.value == num) {
            /*check if we are in a leaf*/
            if (tree.right == null && tree.left == null) // unlink this node
                return null;
            /*Search node to replace this*/
            TreeNode current = null; // iterator to search replacement
            if (tree.left != null) {
                // search max value in left branch
                current = tree.left;
                while (current.right != null) // stop before null node
                    current = current.right;
                /*change values*/
                tree.value = current.value;
                tree.left = this.removeNode(tree.left, tree.value);
            } else {
                // search min value in right branch
                current = tree.right;
                while (current.left != null) // stop before null node
                    current = current.left;
                /*change values*/
                tree.value = current.value;
                tree.right = this.removeNode(tree.right, tree.value);
            }
        }
        
        /*Value never existed in tree*/
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
        
        System.out.println("Tree:");
        bst.printInOrder(root);
        
        root = bst.removeNode(root, 5);
        root = bst.removeNode(root, 3);
        
        System.out.println("Tree:");
        bst.printInOrder(root);
    }
    
}
