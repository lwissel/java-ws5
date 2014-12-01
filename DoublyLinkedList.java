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
        else
          return this.person.getName();
      }

  } // end inner class

  // fields for DLL class
  private int depth;
  private Node headNode;
  private Node tailNode;

  private DoublyLinkedList dll;

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

  /** public methods to add elements at (right of) head
   * @param p is the Person to add
   */
  public void addHead(Person person) {
    this.addPersonRightOf(this.headNode, person);
  }

  /** public methods to add elements at (left of) tail
   * @param p is the Person to add
   */
  public void addTail(Person person) {
    this.addPersonLeftOf(this.tailNode, person);
  }

  /** Getter for depth
   * @return depth of list = size = number of person objects
   */
  public int getDepth() {
    return this.depth;
  }

  /** is the list empty?
   * @return true if depth is 0
   */
  public boolean isEmpty() {
      return (this.depth == 0);
  }


  // right
  // left
  // tostring
  // equals
  // neighbours of opposite gender?
  // empty
  public static DoublyLinkedList empty() {
    return new DoublyLinkedList();
  }
  // cons
  public static DoublyLinkedList cons(Person person, DoublyLinkedList dll) {
    DoublyLinkedList newDll = dll;
    newDll.addHead(person);
    return newDll;
  }

  /** public to string method
   * @return toString representation
   * here we print all Nodes including their references
   */
  @Override
    public String toString(){
          String s = "";
         
          Node tmpNode = headNode.getRightNode();
          while(tmpNode != tailNode){
              s += "Left: " + tmpNode.getLeftNode() + ", Value: " + tmpNode + ", Right: " + tmpNode.getRightNode() + "\n";
              tmpNode = tmpNode.getRightNode();
          }
           
          s += " ";
           
          return s;
    }
}
  
