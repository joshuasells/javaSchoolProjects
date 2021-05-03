import java.io.Serializable;

/**
 * Person
 */
public class Person implements Serializable {
  
  private String fName;
  private String lName;
  private Address address;
  private String email;
  private String note;

  public Person(String fName, String lName, Address address, String email, String note) {
    this.fName = fName;
    this.lName = lName;
    this.address = address;
    this.email = email;
    this.note = note;
  }

  //----------GET METHODS--------------------//

  public String getFName() {
    return this.fName;
  }

  public String getlName() {
    return this.lName;
  }

  public Address getAddress() {
    return this.address;
  }

  public String getEmail() {
    return this.email;
  }

  public String getNote() {
    return this.note;
  }

  //--------------SET METHODS--------------------//

  public void setfName(String fName) {
    this.fName = fName;
  }
  
  public void setlName(String lName) {
    this.lName = lName;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setNote(String note) {
    this.note = note;
  }

  //------------OTHER METHODS-------------//

  @Override
  public String toString() {
    if (this.fName.equalsIgnoreCase("")) {
      return "New Contact";
    }
    return this.lName + ", " + this.fName;
  } 
}