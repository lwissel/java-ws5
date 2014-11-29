import static org.junit.Assert.*;
import org.junit.Test;


public class Ex1MyTest {
  
  /**
   * Test 1  Person class equals
   *
   * equals method
   */
  @Test
    public void ex1Test1() {
      Person p = new Person("H","m",1);
      assertTrue(p.equals(p));
    }
  @Test
    public void ex1Test2() {
      Person p1 = new Person("H","m",1);
      Person p2 = new Person("H","m",1);
      assertTrue(p1.equals(p2));
    }
  @Test
    public void ex1Test3() {
      Person p1 = new Person("H","m",1);
      Person p2 = new Person("H","m",1);
      assertTrue(p2.equals(p1));
    }
}
