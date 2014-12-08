package ex1;

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
  @Test
    public void ex1Test4() {
      Person ann = new Person("Ann", "F", 21);
      Person mary = new Person("Mary", "F", 22);
      Person joan = new Person("Joan","F",24);
      Person tom = new Person("Tom", "M", 22);

      DoublyLinkedList table = DoublyLinkedList.cons(ann, DoublyLinkedList.cons(mary, 
          DoublyLinkedList.cons(joan, DoublyLinkedList.cons(tom, DoublyLinkedList.empty()))));
      String test = "Name: Ann, Gender: F, Age: 21, Name: Mary, Gender: F, Age: 22, Name: Joan, Gender: F, Age: 24, Name: Tom, Gender: M, Age: 22";
        assertTrue(test.equals(table.toString()));
    }
  @Test
    public void ex1Test5() {
      Person ann = new Person("Ann", "F", 21);
      Person mary = new Person("Mary", "F", 22);
      Person joan = new Person("Joan","F",24);
      Person tom = new Person("Tom", "M", 22);

      DoublyLinkedList table = DoublyLinkedList.cons(ann, DoublyLinkedList.cons(mary, 
          DoublyLinkedList.cons(joan, DoublyLinkedList.cons(tom, DoublyLinkedList.empty()))));
      assertFalse(DoublyLinkedList.check(table));
    }
  @Test
    public void ex1Test6() {
      Person ann = new Person("Ann", "F", 21);
      Person mary = new Person("Mary", "F", 22);
      Person joan = new Person("Joan","F",24);
      Person tom = new Person("Tom", "M", 22);

      DoublyLinkedList table = DoublyLinkedList.cons(ann, DoublyLinkedList.cons(mary, 
          DoublyLinkedList.cons(joan, DoublyLinkedList.cons(tom, DoublyLinkedList.empty()))));
      assertFalse(DoublyLinkedList.check(table.getRight()));
    }
}
