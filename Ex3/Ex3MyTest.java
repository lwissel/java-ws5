import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;


public class Ex3MyTest {
  
  public static long[] frequency = new long[28];
  /**
   * Test for externally counted occurences
   */
  @BeforeClass
    public static void setUp() {

      Ex3.frequencyAnalysis("DonQuixote.txt");
    }
  @Test // a
    public void ex3Test1() {
      assertTrue(Ex3.frequency[0] == 148970);
    }
  @Test // b
    public void ex3Test2() {
      assertTrue(Ex3.frequency[1] == 25519);
    }
  @Test // c
    public void ex3Test3() {
      assertTrue(Ex3.frequency[2] == 41224);
    }

  @Test // d
    public void ex3Test4() {
      assertTrue(Ex3.frequency[3] == 81586);
    }

  @Test // line count
    public void ex3Test5() {
      assertTrue(Ex3.frequency[28] == 40006);
    }
  @Test // full stops
    public void ex3Test6() {
      assertTrue(Ex3.frequency[27] == 68099);
    }
}
