/**
 * Person
 */
public class Person {
  private String fName;
  private String lName;

  public Person(String fName, String lName) {
    this.fName = fName;
    this.lName = lName;
  }

  public String getFName() {
    return this.fName;
  }

  public String getlName() {
    return this.lName;
  }

  public void setfName(String fName) {
    this.fName = fName;
  }
  
  public void setlName(String lName) {
    this.lName = lName;
  }

  @Override
  public String toString() {
    return this.lName + ", " + this.fName;
  } 
}