import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;


public class Ex2MyTest {
  
  private Person tom, ann, joe, mary, tim;
  /**
   * Test for externally counted occurences
   */
  @Before
    public void setUp() {
    tom = new Person("tom", "m", 22);
    ann = new Person("ann", "f", 22);
    joe = new Person("joe", "m", 23);
    mary = new Person("mary", "f", 23);
    tim = new Person("tim", "m", 24);
    }

  @Test
    public void ex2Test1() {
      Tree test = new Tree();
      test.insert(mary);

      test.insert(ann);
      test.insert(tom);

      System.out.println(test.getValue());
      System.out.println(test.getRight().getValue());
      System.out.println(test.getLeft().getValue());

    }
}
