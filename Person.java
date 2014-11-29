/** Exercise 1 ws5
 *
 * Assuming the Person class exists ;)
 *
 * @author  Lennart Wissel
 * @version 29.11.2014
 */

public class Person {
  private String name;
  private String gender;
  private int age;

  /** full constructor
   * @param name Name
   * @param gender Gender
   * @param age Age
   */
  public Person(String name, String gender, int age) {
    this.name = name;
    this.gender = gender;
    this.age = age;
  }

  /** GETTERS
   * @return name
   */
  public String getName() {
    return this.name;
  }
  /**
   * @return gender
   */
  public String getGender() {
    return this.gender;
  }
  /**
   * @return age
   */
  public int getAge() {
    return this.age;
  }

  /** SETTERS
   * @param name set name to name
   */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * @param gender set gender to gender
   */
  public void setGender(String gender) {
    this.gender = gender;
  }
  /**
   * @param age set age to age
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * @return toString properties of object person
   */
  @Override
    public String toString() {
      return "Name: " + name + ", Gender: " + gender + ", Age: " + age;
    }

  /**
   * @return if p1 equals p2
   */
    public boolean equals(Person p) {
      if (p == null) { 
        return false;
      }
      if (p.getName().equals(this.name) && p.getGender().equals(this.gender) && p.getAge() == this.age) {
        return true;
      }
      else {
        return false;
      }
    }
}
