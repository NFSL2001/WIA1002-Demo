package w12;

import java.util.ArrayList;
import java.util.Scanner;

public class BST<E extends Comparable<E>> {
    TreeNode<E> root;
    int size = 0;
    
    /**
     * Returns true if the element is in the tree
     * @param e
     * @return true if e is in tree, else false
     */
    public boolean search(E e) {
        TreeNode<E> current = this.root;
        while (current != null) {
            if (current.element.equals(e)) {
                return true;
            }
            if (current.element.compareTo(e) > 0){
                // current is larger than e
                current = current.leftNode;
            } else {
                // current is smaller than e
                current = current.rightNode;
            }
        }
        return false;
    }

    /**
     * Insert element e into the binary tree and return true if the element is inserted successfully. No duplicates are allowed
     * @param e element to insert into BST
     * @return true if inserted successfully, else false
     */
    public boolean insert(E e) {
        TreeNode<E> newNode = new TreeNode<>(e);
        // no root
        if (root == null) {
            this.root = newNode;
            size++;
            return true;
        }
        
        TreeNode<E> current = this.root;
        while (current != null) {
            if (current.element.compareTo(e) > 0) {
                // current is larger than e
                if (current.leftNode == null) {
                    current.leftNode = newNode;
                    break;
                } else
                    current = current.leftNode;
            } else if (current.element.compareTo(e) < 0) {
                // current is smaller than e
                if (current.rightNode == null) {
                    current.rightNode = newNode;
                    break;
                } else
                    current = current.rightNode;
            } else {
                // verify that this is equal to e
                assert current.element.equals(e);
                // current is equal to e, do not insert
                return false;
            }
        }
        size++;
        return true;
    }
    
    /**
     * Get the number of nodes in the tree
     * @return total number of nodes/elements in BST
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Returns the number of layers in the BST. If BST has 1 element then height is 0
     * @return height of the BST
     */
    public int height() {
        if (this.root == null) return -1;
        
        int leftDepth = height(this.root.leftNode);
        int rightDepth = height(this.root.rightNode);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // recursive private method to get depth of given node
    private int height(TreeNode<E> node) {
        if (node == null) return -1;

        int leftDepth = height(node.leftNode);
        int rightDepth = height(node.rightNode);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * Returns the element of the root of the BST
     * @return element of the root of the BST
     */
    public E getRoot() {
        return this.root.element;
    }

    /**
     * Return the minimum value of BST. Will throw NullPointerException if BST is empty
     * @return the element of minimum value
     */
    public E minValue() {
        if (this.root == null) throw new NullPointerException();
        
        TreeNode<E> current = this.root;
        while (current.leftNode != null) {
            current = current.leftNode;
        }
        return current.element;
    }
    
    /**
     * Return the maximum value of BST. Will throw NullPointerException if BST is empty
     * @return the element of minimum value
     */
    public E maxValue() {
        if (this.root == null) throw new NullPointerException();
        
        TreeNode<E> current = this.root;
        while (current.rightNode != null) {
            current = current.rightNode;
        }
        return current.element;
    }

    /**
     * Returns a path from the root leading to the specified element, will be empty if given element is not in BST
     * @param e element to search in BST
     * @return path from root to e, will be empty if e is not in BST
     */
    public java.util.ArrayList<TreeNode<E>> path(E e) {
        ArrayList<TreeNode<E>> fullpath = new ArrayList<>();
        if (this.root == null) return fullpath;
        if (!this.search(e)) return fullpath;

        TreeNode<E> current = this.root;
        while (current != null){
            fullpath.add(current);
            if (current.element.compareTo(e) > 0){
                // current is larger than e
                current = current.leftNode;
            } else if (current.element.compareTo(e) < 0) {
                // current is smaller than e
                current = current.rightNode;
            } else {
                // verify that this is equal to e
                assert current.element.equals(e);
                // current is equal to e
                break;
            }
        }
        return fullpath;
    }

    /**
     * Delete an element from the binary tree. Return true if the element is deleted successfully, and return false if the element is not in the tree
     * @param e element to be deleted in BST
     * @return true if e is deleted, else false
     */
    public boolean delete(E e) {
        if (this.root == null) return false;
        if (!this.search(e)) return false;

        ArrayList<TreeNode<E>> fullpath = this.path(e);
        TreeNode<E> current = fullpath.get(fullpath.size() - 1);
        TreeNode<E> parent = null; // assume root element
        if (fullpath.size() > 1){
            // not root element, has ancestors when traversing
            // get its immediate parent
            parent = fullpath.get(fullpath.size() - 2);
        }
        if (current.leftNode == null && current.rightNode == null) {
            // no child
            if (parent == null) {
                // root element
                this.root = null;
            } else {
                if (parent.leftNode == current) 
                    parent.leftNode = null;
                else 
                    parent.rightNode = null;
            }
        } else if (current.leftNode == null){
            // right child only
            if (parent == null) {
                // root element
                this.root = current.rightNode;
            } else {
                if (parent.leftNode == current) 
                    parent.leftNode = current.rightNode;
                else 
                    parent.rightNode = current.rightNode;
            }
        } else {
            // has left child
            TreeNode<E> nextRightmost = current.leftNode;
            TreeNode<E> nextRightmostParent = current;
            // special case where left subtree root dont have right node
            if (nextRightmost.rightNode == null) {
                // directly move it up
                nextRightmost.rightNode = current.rightNode;
                //reduce size
                size--;
                return true;
            }

            // travel to find rightmost node of left subtree
            while(nextRightmost.rightNode != null) {
                nextRightmostParent = nextRightmost;
                nextRightmost = nextRightmost.rightNode;
            }
            // if rightmost of left subtree has left child, copy to its parent
            if (nextRightmost.leftNode != null) {
                nextRightmostParent.rightNode = nextRightmost.leftNode;
            } else {
                // remove the node from parent
                nextRightmostParent.rightNode = null;
            }
            // move the rightmost node to replace the current node
            nextRightmost.leftNode = current.leftNode;
            nextRightmost.rightNode = current.rightNode;
            if (parent == null) {
                // root element
                this.root = nextRightmost;
            } else {
                // change parent
                if (parent.leftNode == current) 
                    parent.leftNode = nextRightmost;
                else 
                    parent.rightNode = nextRightmost;
            }
        }
        // reduce size
        size--;
        return true;
    }

    /**
     * Remove all elements from the tree
     * @return true
     */
    public boolean clear() {
        this.root = null;
        this.size = 0;
        return true;
    }

    /**
     * Display inorder traversal from a subtree
     * @param root node to start from
     */
    public void inorder() {this.inorder(this.root);};
    protected void inorder(TreeNode<E> root) {
        if (root.leftNode != null)
            this.inorder(root.leftNode);
        System.out.print(root.element);
        System.out.print(" ");
        if (root.rightNode != null)
            this.inorder(root.rightNode);
    }

    /**
     * Display postorder traversal from a subtree
     * @param root node to start from
     */
    public void postorder() {this.postorder(this.root);};
    protected void postorder(TreeNode<E> root) {
        if (root.leftNode != null)
            this.postorder(root.leftNode);
        if (root.rightNode != null)
            this.postorder(root.rightNode);
        System.out.print(root.element);
        System.out.print(" ");
    }

    /**
     * Display preorder traversal from a subtree
     * @param root node to start from
     */
    public void preorder() {this.preorder(this.root);};
    protected void preorder(TreeNode<E> root) {
        System.out.print(root.element);
        System.out.print(" ");
        if (root.leftNode != null)
            this.preorder(root.leftNode);
        if (root.rightNode != null)
            this.preorder(root.rightNode);
    }
}

class TestBST {
    public static void main(String[] args) {
        BST<Integer> bstree = new BST<>();

        // input data
        // 45, 88, 54, 76, 98, 1, 2, 20, 6, 53, 42, 100, 86, 32, 28, 65, 14
        System.out.print("Input Data: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        // split them to array
        String[] items = input.split(", ");
        for (String i: items){
            // convert to integer insert into tree with given order
            bstree.insert(Integer.parseInt(i));
        }

        // display
        System.out.print("Inorder (sorted): ");
        bstree.inorder();
        System.out.print("\nPostorder: ");
        bstree.postorder();
        System.out.print("\nPreorder: ");
        bstree.preorder();
        System.out.println();

        System.out.printf("Height of BST: %d\n", bstree.height());
        System.out.printf("Root of BST is: %d\n", bstree.getRoot());
        System.out.printf("Check whether 10 is in the tree? %b\n", bstree.search(10));
        
        System.out.println("Delete 53");
        bstree.delete(53);

        System.out.print("Updated Inorder data (sorted): ");
        bstree.inorder();
        System.out.println();

        System.out.printf("Min Value: %d\n", bstree.minValue());
        System.out.printf("Max Value: %d\n", bstree.maxValue());

        System.out.print("A path from the root to 6 is: ");
        for (TreeNode<Integer> node: bstree.path(6))
            System.out.print(Integer.toString(node.element) + " ");
    }
}