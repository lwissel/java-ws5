package ex4;
/** Excercise 4 ws5
 *
 * Tree representation
 *
 * @author  Lennart Wissel
 * @version 05.12.2014
 */
import java.util.*;

public class Tree implements Comparable<Tree> {

    private long freq;
    private char ch;
    private Tree left;
    private Tree right;
    private boolean isEmpty;

    /** constructor for given subtrees
     *
     * @param left left htree
     * @param right right htree
     */
    public Tree(Tree left, Tree right) {
      this.freq = left.getFreq() + right.getFreq();
      this.left = left;
      this.right = right;
      this.ch = '\0'; // no character
      this.isEmpty = false;
    }

    /** full constructor;
     *
     * @param left left htree
     * @param right right htree
     * @param freq  frequency
     * @param ch is character value
     */
    public Tree(long freq, char ch, Tree left, Tree right) {
      this.freq = freq;
      this.ch = ch;
      this.left = left;
      this.right = right;
      this.isEmpty = false;
    }
    
    /** empty constructor for new tree;
     */
    public Tree() {
      this.isEmpty = true;
    }
    
    // compare on freq
    @Override
      public int compareTo(Tree tree) {
        return (int)freq - (int)tree.freq;
      }
    

    /**
     * getters
     * @return tree left
     */
    public Tree getLeft() {
      //if (left.isEmpty())
        //throw new IllegalStateException("empty left tree");
      return this.left;
    }
    /**
     * @return Tree right
     */
    public Tree getRight() {
      //if (right.isEmpty())
       // throw new IllegalStateException("empty right tree");
      return this.right;
    }
    /**
     * @return freq
     */
    public long getFreq() {
      if (isEmpty)
        throw new IllegalStateException("empty tree");
      return this.freq;
    }

    /**
     * @return ch
     */
    public char getCh() {
      if (isEmpty)
        throw new IllegalStateException("empty tree");
      return this.ch;
    }

    /**
     * @return is empty
     */
    public boolean isEmpty() {
      return this.isEmpty;
    }
}
