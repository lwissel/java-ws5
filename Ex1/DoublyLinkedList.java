/** Excercise 1 ws 5
 * adapted from fridays tutorial class
 *
 * @author  Lennart Wissel
 * @version 05.12.2014
 */
public class DoublyLinkedList {

	private boolean empty;
	private Person person;
	private DoublyLinkedList left;
	private DoublyLinkedList right;
	
  /** empty constructor
   */
	public DoublyLinkedList() {
		this.empty = true;
	}
	
  /** full constructor
   * @param person is the value
   * @param right is the right dll
   */
	public DoublyLinkedList(Person person, DoublyLinkedList right) {
		this.empty = false;
		this.person = person;
		this.left = new DoublyLinkedList();
		this.right = right;
		this.getRight().setLeft(this);
	}

  /**
   * @return true if empty is set
   */
	public boolean isEmpty() {
		return empty;
	}

  /** sets empty
   * @param empty sets true/false
   */
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

  /** getter for person
   * @return person;
   */
	public Person getPerson() {
    if(isEmpty())
      throw new IllegalStateException("Trying to access value of empty list");
		return person;
	}

  /** setter for person
   * @param person set person
   */
	public void setPerson(Person person) {
		this.person = person;
	}

  /** get left
   * @return left sublist
   */
	public DoublyLinkedList getLeft() {
    if(isEmpty())
      throw new IllegalStateException("Trying to get left of empty list");
		return left;
	}

  /** set left
   * @param left list
   */
	public void setLeft(DoublyLinkedList left) {
		this.left = left;
	}

  /** getter right list
   * @return right dll
   */
	public DoublyLinkedList getRight() {
    if(isEmpty())
      throw new IllegalStateException("Trying to get right of empty list");
		return right;
	}

  /** set right
   * @param right list
   */
	public void setRight(DoublyLinkedList right) {
		this.right = right;
	}

  /** equals
   * @param list1 list 1
   * @param list2 list 2
   * @return equals if both are the same
   */
  public static boolean equals(DoublyLinkedList list1, DoublyLinkedList list2) {
    if (list1.isEmpty() && list2.isEmpty())
      return true;
    else if (list1.isEmpty() || list2.isEmpty())
      return false;
    else if (list1.getPerson().equals(list2.getPerson()))
      return equals(list1.getRight(), list2.getRight());
    else {
      return false;
    }
  }

  /** cons method
   * @param p person
   * @param list dll to set right
   */
  public static DoublyLinkedList cons(Person p, DoublyLinkedList list) {
    return new DoublyLinkedList(p, list);
  }
	
}
