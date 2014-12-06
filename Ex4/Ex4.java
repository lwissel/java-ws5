/** Excercise 4 ws5
 *
 * Tree representation runner class
 *
 * @author  Lennart Wissel
 * @version 05.12.2014
 */
import java.util.*;

public class Ex4 {

  public static void main(String[] args) {
		long[] frequencies = {148970,25519,41224,81586,219488,41740,34245,125330,121889,1654,12516,66773,45899,124802,146903,26297,4213,100115,114741,169435,50147,18704,40609,4562,33237,1106,395475,68099,40006};

    Tree htree;
    htree = Tree.generateTree(frequencies);
    System.out.println(htree);
    /**
    GENERATE TREE
    */
  }
    
}
