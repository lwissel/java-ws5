/** Excercise 1 ws5
 *
 * class to represent doubly linked lists
 *
 * @author  Lennart Wissel
 * @version 29.11.2014
 */

public class DoublyLinkedList {

  /**
   * Nested inner class Node to represent previous and next elements
   */
  private class Node {
    private Person person;
    private Node nextNode;
    private Node previousNode;

    /** full constructor
     * @param person Person
     * @param nextNode next Node
     * @param previousNode previous Node
     */
    public Node(Node nextNode, Person person, Node previousNode) {
      this.nextNode = nextNode;
      this.person = person;
      this.previousNode = previousNode;
    }

    /** start constructor
     * @param person generates node [null - person - null]
     */
    public Node(Person person) {
      this(null, person, null);
    }

    /** GETTERS
     * @return node of next node
     */
    public Node getNextNode() {
      return this.nextNode;
    }
    /**
     * @return node of previous node
     */
    public Node getPreviousNode() {
      return this.previousNode;
    }

  } // end inner class

  // fields for DLL class
  private Node node;
  private Node nextNode;
  private Node previousNode;
  private Node firstNode;
  private Node lastNode;

  private DoublyLinkedList rightDLL;
  private DoublyLinkedList left;


  /** full constructor
   * @param left is the dll to the left
   * @param nodeValue is the node value
   * @param right is the dll to the right
   */
  public DoublyLinkedList(Person person, DoublyLinkedList rightDLL) {
    if(rightDLL == null) { // no previous node exists therefore create a new null-person-null node
      this.node = new Node(person);
      this.firstNode = this.node; // this will be the firstNode for the whole DLL
      this.lastNode = this.node; // set the current node to be the last node, this will change
    }
    if (rightDLL != null) { // there already exists a node therefore we just add a node to the dll
      this.firstNode = rightDLL.getFirstNode();
      this.node = new Node(null, person, rightDLL.getLastNode()) ;
      this.lastNode = node; // will be the lastNode of the next recursive call in the line above
    }
  }

  /**
   * empty constructor returns null
   */
  public DoublyLinkedList() {
    this.rightDLL = null;
  }

  /** GETTER
   * @return the first node of the DLL
   */
  public Node getFirstNode() {
    return this.firstNode;
  }
  /**
   * @return the last node of the DLL
   */
  public Node getLastNode() {
    return this.lastNode;
  }

  /** static method to construct DLLs
   * @param person Person
   * @param right is the DLL to the right
   * @return a new DLL
   */
  public static DoublyLinkedList cons(Person person, DoublyLinkedList right) {
    return new DoublyLinkedList(person,right);
  }

  /** static method to represent the end of the list
   * @return a new DLL
   */
  public static DoublyLinkedList empty() {
    return new DoublyLinkedList();
  }


  /*
  @Override
    public String toString(DoublyLinkedList dll) {
     
    }
    */
}
