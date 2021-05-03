/**
 * Item.java
 * Author: Joshua Sells
 * Email: joshuataylorsells@gmail.com
 * Week 2 programming assignment
 */

public class Item {

  // Variables
  private String title;
  private double price;

  // Constructor
  public Item(String title, double price) {
    this.title = title;
    this.price = price;
  }

  // ----------------GET and SET methods-------------- //

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}