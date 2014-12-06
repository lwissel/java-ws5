/** Excercise 4 ws5
 *
 * Tree representation
 *
 * @author  Lennart Wissel
 * @version 05.12.2014
 */
import java.util.*;

public class Tree {
  private class Node {
    private long freq;
    private char value;

    public Node(long freq, char value) {
      this.freq = freq;
      this.value = value;
    }

    @Override
    public String toString() {
      return value + " " + freq;
    }

    /** getter
     * @return freq
     */
    public long getFreq() {
      return this.freq;
    }
    /** getter
     * @return value
     */
    public long getValue() {
      return this.value;
    }
  }

    private Node root;
    private Tree left;
    private Tree right;
    private boolean isEmpty;

    /** empty constructor
     */
    public Tree() {
      this.isEmpty = true;
    }

    /** constructor to generate 1 element tree
     * @param value Node value
     */
    public Tree(Node value) {
      this.root = value;
      this.left = new Tree();
      this.right = new Tree();
      this.isEmpty = false;
    }

    /** full constructor
     *
     * @param value node value (freq, char)
     * @param left left htree
     * @param right right htree
     */
    public Tree(Node value, Tree left, Tree right) {
      this.root = value;
      this.left = left;
      this.right = right;
      this.isEmpty = false;
    }

    /**getter for root
     * @return root node
     */
    public Node getRoot() {
      return this.root;
    }

    /** method to set the root node
     * @param root new root node
     */
    public void setRoot(Node root) {
      if(isEmpty) {
        this.left = new Tree();
        this.right = new Tree();
        this.isEmpty = false;
      }
      this.root = root;
    }

    /** method to set the left htree
     * @param left htree 
     */
    public void setLeft(Tree left) {
      if(isEmpty) {
        throw new IllegalStateException("Trying to access left htree of empty tree");
      }
      else
        this.left = left;
    }

    /** method to set the right htree
     * @param right htree 
     */
    public void setRight(Tree right) {
      if(isEmpty) {
        throw new IllegalStateException("Trying to access right htree of empty tree");
      }
      else
        this.right = right;
    }

    /** method to generate arraylist of nodes
     * for given alphabet a-z, whitespace, period, linecount
     *
     * maps whitespace to { = 123
     * maps period to | = 124
     * maps linecount to } = 125
     */
    public ArrayList<Node> generateNodeList(long[] frequency) {

      ArrayList<Node> nList = new ArrayList<Node>();
      for(int i = 0; i < frequency.length; i++) {
        nList.add(new Node(frequency[i], (char)(i+97)));
      }
      return nList;
    }

  /**
   * sorting the list by overriding the given compare method for lists
   */
  public void sortNList(ArrayList<Node> nList) {
    Collections.sort(nList, new Comparator<Node>() {
      @Override
      public int compare(Node n1, Node n2) {
        return (int)n1.getFreq() - (int)n2.getFreq(); 
      }
    });
  }

    /** method to generate huffman tree
     * @param freqs long[] containing freq counts
     * @return new huffman tree
     */
    public Tree genTree(long[] freq) {
      Tree result = new Tree();
      ArrayList<Node> nList = generateNodeList(freq);
      sortNList(nList);
      
      // for lists with only 1 element the htree is trivial
      if(nList.size() == 1) {
        result.setRoot(nList.get(0));
        return result;
      }

      // add first element to htree result
      Node newRoot = new Node(nList.get(0).getFreq() + nList.get(1).getFreq(),'\0');
      Tree newLeft = new Tree(nList.get(0));
      Tree newRight = new Tree(nList.get(1));
      result.setRoot(newRoot);
      result.setLeft(newLeft);
      result.setRight(newRight);

      // add middle elements
      while (nList.size() > 1) {
        newRoot = new Node(nList.get(0).getFreq() + nList.get(1).getFreq(),'\0');
        result = new Tree(newRoot, result, new Tree(nList.get(1)));
        nList.remove(1); // important to first remove 2nd element in the list!
        nList.remove(0);
        nList.add(newRoot);
        sortNList(nList);
      }

      // add last element in case of uneven list
      if (nList.size() == 1) {
        newRoot = new Node(nList.get(0).getFreq() + result.getRoot().getFreq(),'\0');
        result = new Tree(newRoot, result, new Tree(nList.get(0)));
        nList.remove(0);
      }

      if (nList.size() != 0)
        throw new IllegalStateException("Something went wrong!");

      return result;
    }

    /** static method to use to generate tree
     * @param freq list
     * @return htree
     */
    public static Tree generateTree(long[] list) {
      Tree t = new Tree();
      return t.genTree(list);
    }
   
    @Override
      public String toString() {
        if (isEmpty)
          return "";
        else
          return "R: " + this.getRoot().toString() + "\n L: " + this.left.toString() + "\n R: " + this.right.toString();
    }    
	    
}
