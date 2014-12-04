import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;


public class Ex2MyTest {
  
  private Person tom, ann, joe, mary, tim;
  private Tree test;
  /**
   * Test for externally counted occurences
   */
  @Before
    public void setUp() {
    tom = new Person("tom", "m", 25);
    ann = new Person("ann", "f", 22);
    joe = new Person("joe", "m", 23);
    mary = new Person("mary", "f", 23);
    tim = new Person("tim", "m", 24);

      test = new Tree();
      test.insert(mary);

      test.insert(ann);
      test.insert(tom);
      test.insert(joe);
      test.insert(tim);
    }

  // insert methods
  @Test
    public void ex2Test1() {
      System.out.println(test.getValue());
    }
  @Test
    public void ex2Test2() {
      System.out.println(test.getRight().getValue());
    }
  @Test
    public void ex2Test3() {
      System.out.println(test.getLeft().getValue());
    }
  @Test // lookup
    public void ex2Test4() {
      System.out.println(test.lookupAge("mary")); // 23
    }
  @Test // lookup
    public void ex2Test5() {
      System.out.println(test.lookupAge("ann")); // 22
    }
  @Test // lookup
    public void ex2Test6() {
      System.out.println(test.lookupAge("joe")); // 23
    }
  @Test // lookup
    public void ex2Test7() {
      System.out.println(test.lookupAge("tom")); // 25
    }
  @Test // lookup
    public void ex2Test8() {
      System.out.println(test.lookupAge("")); // -1
    }
  @Test // lookup
    public void ex2Test9() {
      System.out.println(test.lookupAge(" ")); // -1
    }
}
