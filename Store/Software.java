/**
 * Software.java
 * Author: Joshua Sells
 * Email: joshuataylorsells@gmail.com
 * Week 2 programming assignment
 */

public class Software extends Item {

  // Variable
  private String version;

  // Constructor
  public Software(String title, double price, String version) {
    super(title, price);
    this.version = version;
  }

  // ----------------GET and SET methods-------------- //

  public String getVersion() {
    return this.version;
  }

  public void setVersion(String version) {
    this.version = version;
  }
}