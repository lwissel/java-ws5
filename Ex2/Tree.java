/** Adapted Tree class for Excercise 2 ws5
 * by Lennart Wissel
 * 
 * @author Uday Reddy, with changes by Manfred Kerber
 * @version 2014-11-26 based on Uday's version of 2012
 * 
 * Tree class defines a recursive type called Tree (for Binary Trees), and provides
 * constructor and getter methods. 
 */

public class Tree {

    /**
     * Tree class defines a recursive type called Tree, and provides
     * constructors and getters.
     */
    private boolean empty;
    private Person value;
    private Tree left, right;
    

    /**
     * Creates a new Tree whose root value is x and left and right
     * subtrees are r and l 
     */
    public Tree(Person value, Tree left, Tree right) {
        this.empty = false; 
        this.value = value; 
        this.left = left; 
        this.right = right;
    }
	    
    /**
     * Creates an empty tree
     */
    public Tree() {
        this.empty = true;
    }
	    
    /**
     * returns true if this tree is empty (eg nil)
     */
    public boolean isEmpty() {
        return empty;
    }
	    
    /**
     * gets the root value of this tree
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
     */
    public Tree getLeft() {
        if (isEmpty()) {
            throw new IllegalStateException(
                                            "Trying to access subtree of an empty tree");
        }
        return left;
    }
	    
    /**
     * gets the right subtree of this node
     */
    public Tree getRight() {
        if (isEmpty()) {
            throw new IllegalStateException(
                                            "Trying to access subtree of an empty tree");
        }
        return right;
    }
	    
    public String bar(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.insert(i, '|');
        }
        return result.toString();
    }
	    
    public final static Tree emptyTree = new Tree();


    public void insert(Person value) {
      if(this.isEmpty()) {
        this.left = emptyTree;
        this.right = emptyTree;
        this.value = value;
        this.empty = false;
      }
      if (value.getName().compareTo(this.value.getName()) == 0) {
      }
      if (value.getName().compareTo(this.value.getName()) < 0) {
        this.right.insert(value);
      }
      if (value.getName().compareTo(this.value.getName()) > 0) {
        this.left.insert(value);
      }
    }
}
