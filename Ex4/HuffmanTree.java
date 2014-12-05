/** Excercise 4 ws5
 *
 * HuffmanTree representation
 *
 * @author  Lennart Wissel
 * @version 05.12.2014
 */

public class HuffmanTree {
  private class Node {
    private long freq;
    private char value;

    public Node(long freq, char value) {
      this.freq = freq;
      this.value = value;
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

    /** method to generate huffman tree
     * @param freqs long[] containing freq counts
     * @return new huffman tree
     */
    public static HuffmanTree generateTree(long[] freq) {
      return new HuffmanTree();
    }
}
