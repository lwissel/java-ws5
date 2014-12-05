/** Excercise 4 ws5
 *
 * HuffmanTree representation
 *
 * @author  Lennart Wissel
 * @version 05.12.2014
 */
import java.util.*;

public class HuffmanTree {
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
    private HuffmanTree left;
    private HuffmanTree right;
    private boolean isEmpty;

    /** empty constructor
     */
    public HuffmanTree() {
      this.isEmpty = true;
    }

    /** constructor to generate 1 element tree
     * @param value Node value
     */
    public HuffmanTree(Node value) {
      this.root = value;
      this.left = new HuffmanTree();
      this.right = new HuffmanTree();
      this.isEmpty = false;
    }

    /** full constructor
     *
     * @param value node value (freq, char)
     * @param left left htree
     * @param right right htree
     */
    public HuffmanTree(Node value, HuffmanTree left, HuffmanTree right) {
      this.root = value;
      this.left = left;
      this.right = right;
      this.isEmpty = false;
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
     *  if (frequencies.length > 1) // what if =1 ??
     *    generate arraylist of nodes (freq, letter);
     *    sort arraylist;
     *  while frequencies list.length > 1 {
     *    newrootNode = (frequencies[0] + frequencies[1])
     *    newlefttree = new htree(frequency0,char, empty, empty)
     *    newrightree = new htree(frequency0,char, empty, empty)
     *    insert newrootNode into arraylist at bottom
     *    add to head of huffmann tree(newrootNode, newlefttree, newrighttree);
     *    delete from arraylist
     *    delete from arraylist;
     *    sort arraylist
     *  }
     * @param freqs long[] containing freq counts
     * @return new huffman tree
     */
    public HuffmanTree generateTree(long[] freq) {
      HuffmanTree result = new HuffmanTree();
      ArrayList<Node> nList = generateNodeList(freq);
      sortNList(nList);
      
      while (nList.size() > 1) {
        Node newRoot = new Node(nList.get(0).getFreq() + nList.get(1).getFreq(),'\0');
        HuffmanTree newLeft = result.getLeft();
        HuffmanTree newRight = new HuffmanTree(nList.get(1));
        result.addHead(newRoot, newLeft, newRight);
        nList.remove(0);
        nList.remove(1);
        nList.add(newRoot);
        sortNList(nList);
      }
      return result;
    }
}
