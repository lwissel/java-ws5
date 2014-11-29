/** Exercise 1 ws5
 *
 * Runner class for testing
 *
 * @author  Lennart Wissel
 * @version 29.11.2014
 */

public class Runner {

  public static void main(String[] args) {
    Person tom = new Person("tom", "m", 22);
    Person ann = new Person("ann", "f", 22);
    Person joe = new Person("joe", "m", 23);
    Person mary = new Person("mary", "f", 23);
    Person tim = new Person("tim", "m", 24);
    
    DoublyLinkedList dll = DoublyLinkedList.cons(tom, 
      DoublyLinkedList.cons(ann, 
        DoublyLinkedList.cons(joe, 
          DoublyLinkedList.cons(mary, 
            DoublyLinkedList.cons(tim, DoublyLinkedList.empty())
          )
        )
      )
    );

  }
}
