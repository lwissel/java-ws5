/** Excercise 3 ws5
 *
 * Count char occurences in File
 *
 * @author  Lennart Wisel
 * @version 02.12.2014
 */
import java.io.*;
import java.util.Scanner;

public class Ex3 {

  public static long[] frequency = new long[29];

  /**
   * counting based on utf character values
   * @param str is the string to test
   * sets frequency array
   */
  public static void count(String str) {
    int valueNL = (int)'\n';
    for(int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      int value = (int) c;
      // java character types unicode standard
      // see related stackoverflow question
      if(value >= 97 && value <= 122)
        frequency[c - 97]++; // max is 122-97 = 25
      if(value == 32) // whitespace
        frequency[26]++;
      if(value == 46) // full stop .
        frequency[27]++;
      if(value == valueNL)
        frequency[28]++;
    }
  }
	
	public static void main(String[] args) {

    FileInputStream inputStream = null;
    Scanner sc = null;

    try {
      inputStream = new FileInputStream("DonQuixote.txt");
      sc = new Scanner(inputStream);

      // Read the text line by line and count occurences
      String str;
      while (sc.hasNextLine()) {
        str = sc.nextLine();
        count(str);
        frequency[28]++; // every new line = \n
      }
      // according to baeldung.com/java-read-lines-large-file are exceptions supressed by the scanner
      if (sc.ioException() != null) {
        throw new IOException("No access to input stream");
      }
      if (inputStream != null)
        inputStream.close();
      if(sc != null)
        sc.close();
    }
    catch(IOException e) {
      e.printStackTrace();
    }

    // print occurences
    for(int a = 0; a < frequency.length-3; a++) {
      System.out.println((char)(a+97) + ": " + frequency[a]);
    }
      System.out.println(" " + ": " + frequency[26]);
      System.out.println("." + ": " + frequency[27]);
      System.out.println("\\n" + ": " + frequency[28]);
  }
}

