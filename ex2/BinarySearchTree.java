package ex2;

import ex1.Person;
/** Adapted BinarySearchTree class for Excercise 2 ws5
 * by Lennart Wissel
 * 
 * @author Uday Reddy, with changes by Manfred Kerber
 * @version 2014-11-26 based on Uday's version of 2012
 * 
 * BinarySearchTree class defines a recursive type called BinarySearchTree (for Binary Trees), and provides
 * constructor and getter methods. 
 */

public class BinarySearchTree {

    /**
     * BinarySearchTree class defines a recursive type called BinarySearchTree, and provides
     * constructors and getters.
     */
    private boolean empty;
    private Person value;
    private BinarySearchTree left, right;
    

    /**
     * Creates a new BinarySearchTree whose root value is x and left and right
     * subtrees are r and l 
     * @param value object person here
     * @param left Left tree
     * @param right Right tree
     */
    public BinarySearchTree(Person value, BinarySearchTree left, BinarySearchTree right) {
        this.empty = false; 
        this.value = value; 
        this.left = left; 
        this.right = right;
    }
	    
    /**
     * Creates an empty tree
     */
    public BinarySearchTree() {
        this.empty = true;
    }
	    
    /**
     * returns true if this tree is empty (eg nil)
     * @return true if tree is empty
     */
    public boolean isEmpty() {
        return empty;
    }
	    
    /**
     * gets the root value of this tree
     * @return Person to get root of subtree
     */
    public Person getValue() {
        if (isEmpty()) {
            throw new IllegalStateException(
                                            "Trying to access root of an empty tree");
        }
        return value;
    }
	    
    /**
     * gets the left subtree of this node
     * @return BinarySearchTree left subtree
     */
    public BinarySearchTree getLeft() {
        if (isEmpty()) {
            throw new IllegalStateException(
                                            "Trying to access subtree of an empty tree");
        }
        return left;
    }
	    
    /**
     * gets the right subtree of this node
     * @return BinarySearchTree right subtree
     */
    public BinarySearchTree getRight() {
        if (isEmpty()) {
            throw new IllegalStateException(
                                            "Trying to access subtree of an empty tree");
        }
        return right;
    }
	    
    /** does... something
     * @param n integer
     * @return some string
     */
    public String bar(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.insert(i, '|');
        }
        return result.toString();
    }
	    
    public final static BinarySearchTree emptyTree = new BinarySearchTree();


    /**
     * recursive insert function
     * @param value Person object to insert
     */
    public void ins(Person value) {
      if(this.isEmpty()) {
        this.left = new BinarySearchTree();
        this.right = new BinarySearchTree();
        this.value = value;
        this.empty = false;
      }
      if (value.getName().compareTo(this.value.getName()) == 0) {
      }
      if (value.getName().compareTo(this.value.getName()) > 0) {
        this.right.ins(value);
      }
      if (value.getName().compareTo(this.value.getName()) < 0) {
        this.left.ins(value);
      }
    }

    public static BinarySearchTree insert(Person value, BinarySearchTree bst) {
      bst.ins(value);
      return bst;
    }

    /**
     * search binary tree for specific name
     * @param name Name of person to look for
     * @return age if found, or -1 if not in list
     */
    public int lookupAge(String name) {
      if(this.isEmpty())
        return -1;
      else if(name.compareTo(this.value.getName()) > 0)
        return this.right.lookupAge(name);
      else if(name.compareTo(this.value.getName()) < 0)
        return this.left.lookupAge(name);
      else
        return this.value.getAge();
    }
}
