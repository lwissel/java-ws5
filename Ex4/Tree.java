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

    /** generate tree
     * @param frequencies array
     * @return huffman tree of freqs
     * priorityqueue inspired by rosettacode.org/wiki/huffman
     */
    public static Tree generateTree(long[] frequencies) {
      PriorityQueue<Tree> trees = new PriorityQueue<Tree>();

      for(int i = 0; i < frequencies.length; i++) {
        if (frequencies[i] > 0)
          trees.offer(new Tree(frequencies[i], (char)(i+97), new Tree(), new Tree()));
      }

      if (trees.size() > 0) {
        while (trees.size() > 1) {
          Tree t1 = trees.poll(); // gets first tree and removes it afterwards from the queue
          Tree t2 = trees.poll();

          // insert element by comparator freq
          trees.offer(new Tree(t1,t2)); // makes sure at least one elements stays
        }
      }
      return trees.poll();
    }

    /* to string method
     * @return string representation
     * inspired by rosettacode.org/wiki/huffman
     */
      public static void printTree(Tree tree, StringBuffer pre) {
        if (tree.isEmpty())
          return;

        else {
          if (tree.getCh() != '\0') 
            System.out.println(tree.getCh() + "\t" + tree.getFreq() + "\t" + pre);

          // left 
          pre.append('0');
          printTree(tree.getLeft(), pre);
          pre.deleteCharAt(pre.length()-1);
          
          // right
          pre.append('1');
          printTree(tree.getRight(), pre);
          pre.deleteCharAt(pre.length()-1);
        }
    }
    public static void encHelper(Tree tree, StringBuffer pre, StringBuffer res) {
        if (tree.isEmpty())
          return;

        else {
          if (tree.getCh() != '\0') 
            res.append(tree.getCh()); // + "\t" + pre + "\n");

          // left 
          pre.append('0');
          encHelper(tree.getLeft(), pre, res);
          pre.deleteCharAt(pre.length()-1);
          
          // right
          pre.append('1');
          encHelper(tree.getRight(), pre, res);
          pre.deleteCharAt(pre.length()-1);
        }
    }

    /** method to encode a given string
     * @param str string to encode
     * @param tree huffman tree to use
     */
    public static String encode(String str, Tree tree) {
      Hashtable pairs = new Hashtable();
      StringBuffer res = new StringBuffer();
      encHelper(tree, new StringBuffer(), res);

      System.out.println(res);
      return res.toString();
    }

    /** recursive encode helper method
     *
     * @param tree
     * @param pre
     * @param res is resultstring
     * @return string of format char:encoding\n etc
     */
 /*   public static String encodeHelper(Tree tree, StringBuffer pre, StringBuffer res) {
        if (tree.isEmpty())
          res.append(' ');

        else {
          if (tree.getCh() != '\0')  {
            res.append(tree.getCh());
            res.append(':');
            res.append(pre);
            res.append('\n');
            System.out.println(res.toString());
          }

          // left 
          pre.append('0');
          encodeHelper(tree.getLeft(), pre, res);
          pre.deleteCharAt(pre.length()-1);
          
          // right
          pre.append('1');
          encodeHelper(tree.getRight(), pre, res);
          pre.deleteCharAt(pre.length()-1);
        }
          return res.toString();
    }
}
*/
    /** method to generate arraylist of nodes
     * for given alphabet a-z, whitespace, period, linecount
     *
     * maps whitespace to { = 123
     * maps period to | = 124
     * maps linecount to } = 125
     */
/*
     * public ArrayList<Node> generateNodeList(long[] frequency) {

      ArrayList<Node> nList = new ArrayList<Node>();
      for(int i = 0; i < frequency.length; i++) {
        nList.add(new Node(frequency[i], (char)(i+97)));
      }
      return nList;
    }
*/
  /**
   * sorting the list by overriding the given compare method for lists
   */
/* public void sortNList(ArrayList<Node> nList) {
    Collections.sort(nList, new Comparator<Node>() {
      @Override
      public int compare(Node n1, Node n2) {
        return (int)n1.getFreq() - (int)n2.getFreq(); 
      }
    });
  }
*/
    /** method to generate huffman tree
     * @param freqs long[] containing freq counts
     * @return new huffman tree
     */
/*    public Tree genTree(long[] freq) {
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
*/
    /** static method to use to generate tree
     * @param freq list
     * @return htree
     */
/*    public static Tree generateTree(long[] list) {
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
	*/    
}
