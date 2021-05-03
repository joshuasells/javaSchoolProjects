import java.io.Serializable;

/**
 * Address
 */
public class Address implements Serializable {
  
  private String street;
  private String city;
  private String state;
  private String zip;

  public Address(String street, String city, String state, String zip) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }

  //------------GET METHODS-------------------//

  public String getStreet() {
    return this.street;
  }

  public String getCity() {
    return this.city;
  }

  public String getState() {
    return this.state;
  }

  public String getZip() {
    return this.zip;
  }

  //----------------SET METHODS-----------------//

  public void setStreet(String street) {
    this.street = street;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  //--------------------OTHER METHODS---------------//
  
}
