package ex4;
/** Excercise 4 ws5
 *
 * Tree representation runner class
 *
 * @author  Lennart Wissel
 * @version 05.12.2014
 */
import java.util.*;
 
public class Ex4 {

    /** generate tree
     * @param frequencies array
     * @return huffman tree of freqs
     * usage of PriorityQueue is inspired by rosettacode.org/wiki/huffman
     */
    public static Tree generateTree(long[] frequencies) {
      PriorityQueue<Tree> trees = new PriorityQueue<Tree>();

      for(int i = 0; i < frequencies.length-3; i++) {
        if (frequencies[i] > 0)
          trees.offer(new Tree(frequencies[i], (char)(i+97), new Tree(), new Tree()));
      }
          // set the special needs characters due to excercise
          trees.offer(new Tree(frequencies[26], ' ', new Tree(), new Tree()));
          trees.offer(new Tree(frequencies[27], '.', new Tree(), new Tree()));
          trees.offer(new Tree(frequencies[28], '\n', new Tree(), new Tree()));

      if (trees.size() > 0) {
        while (trees.size() > 1) {
          Tree t1 = trees.poll(); // gets first tree and removes it afterwards from the queue
          Tree t2 = trees.poll();

          // insert element by comparator freq
          trees.offer(new Tree(t1,t2)); // makes sure at least one elements stays
        }
      }
      return trees.poll(); // return the final and last tree that contains all other trees
    }

    /**
     * helper method do build a hashmap
     * @param tree is the huffman tree
     * @param pre is used to build up the binary sequences
     * @param pairs is the hashmap that will be set
     */
    public static void encHelper(Tree tree, StringBuffer pre, Hashtable<Character, String> pairs) {
        if (tree.isEmpty())
          return;

        else {
          if (tree.getCh() != '\0') 
            pairs.put(tree.getCh(), pre.toString());

          // left 
          pre.append('0');
          encHelper(tree.getLeft(), pre, pairs);
          pre.deleteCharAt(pre.length()-1);
          
          // right
          pre.append('1');
          encHelper(tree.getRight(), pre, pairs);
          pre.deleteCharAt(pre.length()-1);
        }
    }

    /** method to encode a given string
     * @param str string to encode
     * @param tree huffman tree to use
     * @return encoded result
     */
    public static String encode(String str, Tree tree) {
      if (tree.isEmpty())
        throw new IllegalStateException("Tree is empty");

      // we will put our characters and encoded binary sequence into a hashmap
      Hashtable<Character, String> pairs = new Hashtable<Character, String>();
      encHelper(tree, new StringBuffer(), pairs);

      // then we build up a character array from our string and compare it to
      // the hashmap, extracting the value and adding it to the output builder
      StringBuilder result = new StringBuilder();
      char[] cArray = str.toCharArray();

      for(char c: cArray) {
        result.append(pairs.get(c));
      }

      return result.toString();
    }

    /** method to decode a given string
     * @param str huffman encoded string
     * @param tree huffman tree to use
     * @return decoded string
     */
    public static String decode(String str, Tree tree) {
      if (tree.isEmpty())
        throw new IllegalStateException("Tree is empty");

      StringBuilder result = new StringBuilder();
      char[] cArray = str.toCharArray();

      // tmp tree to loop through the recursive structure
      // 0 to go left
      // 1 to go right
      // until we reach an empty subtree
      Tree tmp = tree;
      for(char c: cArray) {
        if (tmp.isEmpty() == false) {
          if(c == '0')
            tmp = tmp.getLeft();
          if(c == '1')
            tmp = tmp.getRight();
        }
        if(tmp.getLeft().isEmpty() && tmp.getRight().isEmpty()) {
          result.append(tmp.getCh());
          tmp = tree;
        }
      }
      return result.toString();
    }
}
