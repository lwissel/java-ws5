/** Excercise 1 ws5
 *
 * class to represent doubly linked lists
 *
 * with reference to http://www.dreamincode.net/forums/topic/273905-double-linked-lists-dll/ 
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
    private Node leftNode;
    private Node rightNode;

    /** full constructor
     * @param person Person
     * @param leftNode next Node
     * @param rightNode previous Node
     */
    public Node(Node leftNode, Person person, Node rightNode) {
      this.leftNode = leftNode;
      this.person = person;
      this.rightNode = rightNode;
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
    public Node getLeftNode() {
      return this.leftNode;
    }
    /**
     * @return node of previous node
     */
    public Node getRightNode() {
      return this.rightNode;
    }
    /**
     * @return Person
     */
    public Person getPerson() {
      return this.person;
    }
    
    /** SETTERS
     * @param person set person to
     */
    public void setPerson(Person person) {
      this.person = person;
    }
    /**
     * @param leftNode sets the left node
     */
    public void setLeftNode(Node leftNode) {
      this.leftNode = leftNode;
    }
    /**
     * @param rightNode sets rightNode
     */
    public void setRightNode(Node rightNode) {
      this.rightNode = rightNode;
    }
    
    /**
     * @return customized toString Method
     */
    @Override
      public String toString() {
        if (this.person == null)
          return null;
        else if (this.leftNode == null)
          return "NULL <-> " + this.person.toString() + " <-> " + this.rightNode.getPerson().getName();
        else if (this.rightNode == null)
          return this.leftNode.getPerson().getName() + " <-> " + this.person.toString() + " <-> NULL";
        else
          return this.leftNode.getPerson().getName() + " <-> " + this.person.toString() + " <-> " + this.rightNode.getPerson().getName();
      }

  } // end inner class

  // fields for DLL class
  private int depth;
  private Node headNode;
  private Node tailNode;

  /** default empty constructor
   * creates NULL - HEAD(null) - TAIL(null) - NULL
   */
  public DoublyLinkedList() {
    headNode = new Node(null, null, null);
    tailNode = new Node(null, null, null);
    depth = 0;

    // set links
    headNode.setRightNode(tailNode);
    tailNode.setLeftNode(headNode);
  }

  /** get right node
   * @param refNode is the current reference node
   * @return right node if not null
   */
  private Node getRightNode(Node refNode) {
    if (refNode == tailNode)
      throw new IllegalStateException("Trying to access Node right of tail");
    else
      return refNode.getRightNode();
  }

  /** get left node
   * @param refNode is the current reference node
   * @return left node if not null
   */
  private Node getLeftNode(Node refNode) {
    if (refNode == headNode)
      throw new IllegalStateException("Trying to access Node left of head");
    else
      return refNode.getLeftNode();
  }

  /** add node left of refNode
   * @param refNode is the current reference node
   */
  private void addPersonLeftOf(Node refNode, Person person) {
    Node leftNode = this.getLeftNode(refNode);

    // create new node and update the neighbours references
    Node newNode = new Node(leftNode, person, refNode);
    leftNode.setRightNode(newNode);
    refNode.setLeftNode(newNode);

    depth++;
  }

  /** add node right of refNode
   * @param refNode is the current reference node
   */
  private void addPersonRightOf(Node refNode, Person person) {
    Node rightNode = this.getRightNode(refNode);

    // create new node and update the neighbours references
    Node newNode = new Node(refNode, person, rightNode);
    rightNode.setLeftNode(newNode);
    refNode.setRightNode(newNode);

    depth++;
  }

  /** public methods to add elements at(left of) head
   * @param p is the Person to add
   */
  public void addHead(Person person) {
    this.addPersonLeftOf(this.headNode, person);
  }

  /** public methods to add elements at(right of) tail
   * @param p is the Person to add
   */
  public void addTail(Person person) {
    this.addPersonRightOf(this.tailNode, person);
  }
}
