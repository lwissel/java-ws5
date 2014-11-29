/** Excercise 1 ws5
 *
 * class to represent doubly linked lists
 *
 * @author  Lennart Wissel
 * @version 29.11.2014
 */

public class DoublyLinkedList {
  private Person nodeValue;
  private DoublyLinkedList right;
  private boolean empty;


  /** full constructor
   * @param left is the dll to the left
   * @param nodeValue is the node value
   * @param right is the dll to the right
   */
  public DoublyLinkedList(Person nodeValue, DoublyLinkedList right) {
    this.nodeValue = nodeValue;
    this.right = right;
    this.empty = false;
  }

  /** empty constructor to represent null elements
   * we have to throw exceptions in getters and setters if left or right are null
   */
  public DoublyLinkedList() {
    this.empty = true;
  }

  /** static method to construct DLLs
   * @param p Person
   * @param right is the DLL to the right
   * @return a new DLL
   */
  public static DoublyLinkedList cons(Person p, DoublyLinkedList right) {
    return new DoublyLinkedList(p,right);
  }

  /** static method to represent the end of the list
   * @return a new DLL
   */
  public static DoublyLinkedList empty() {
    return new DoublyLinkedList();
  }
}
